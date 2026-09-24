package org.om.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.om.dto.EventCreatedEvent;
import org.om.dto.TokenFailedEvent;
import org.om.dto.TokenRedeemedEvent;

import org.om.model.Token;
import org.om.repository.TokenRepository;
import org.om.repository.TokenRedemptionRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@ApplicationScoped
public class TokenRedemptionConsumer {

    @Inject
    TokenRepository tokenRepository;

    @Inject
    TokenRedemptionRepository redemptionRepository;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    @Channel("token-redeemed")
    Emitter<String> successEmitter;

    @Inject
    @Channel("token-failed")
    Emitter<String> failureEmitter;

    @Transactional
    @Incoming("event-created")
    public void processEvent(String payload) {
        EventCreatedEvent event;
        try {
            event = objectMapper.readValue(payload, EventCreatedEvent.class);
        } catch (Exception e) {
            Log.error("Failed to deserialize event-created payload", e);
            return;
        }

        Log.info("Starting token redemption for eventId: " + event.getEventId() + ", tokenId: " + event.getTokenId());

        UUID eventId = UUID.fromString(event.getEventId());

        // Idempotency check: has this saga event already been processed?
        if (redemptionRepository.existsByEventId(eventId)) {
            Log.info("eventId already processed, skipping: " + event.getEventId());
            return;
        }

        Token token = tokenRepository.findByIdOptional(event.getTokenId()).orElse(null);
        if (token == null) {
            Log.error("Token not found for redemption: " + event.getTokenId());
            emitFailure(failureEmitter, event.getEventId(), event.getTokenId(), "Token not found");
            return;
        }

        if (token.getQuantity() <= 0) {
            Log.error("Token has no quantity remaining: " + event.getTokenId());
            emitFailure(failureEmitter, event.getEventId(), event.getTokenId(), "Token fully redeemed");
            return;
        }

        try {
            // Decrement quantity
            token.setQuantity(token.getQuantity() - 1);

            if (token.getQuantity() == 0) {
                token.setRedeemed(true);
                token.setRedeemedAt(LocalDateTime.now());
            }

            // Track this saga event for idempotency
            redemptionRepository.saveByEventId(event.getTokenId(), eventId);

            // Emit success event
            TokenRedeemedEvent redeemed = new TokenRedeemedEvent();
            redeemed.setEventId(event.getEventId());
            redeemed.setTokenId(event.getTokenId());
            redeemed.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

            Log.info("Token redeemed successfully for eventId: " + event.getEventId());
            successEmitter.send(objectMapper.writeValueAsString(redeemed));
            Log.info("Emitted token-redeemed event for eventId: " + event.getEventId());

        } catch (Exception e) {
            Log.error("Token redemption failed for eventId: " + event.getEventId(), e);
            emitFailure(failureEmitter, event.getEventId(), event.getTokenId(), e.getMessage());
        }
    }

    private void emitFailure(Emitter<String> failureEmitter, String eventId, Long tokenId, String reason) {
        TokenFailedEvent failed = new TokenFailedEvent();
        failed.setEventId(eventId);
        failed.setTokenId(tokenId);
        failed.setFailureReason(reason);
        failed.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        try {
            failureEmitter.send(objectMapper.writeValueAsString(failed));
            Log.info("Emitted token-failed event for eventId: " + eventId);
        } catch (Exception e) {
            Log.error("Failed to serialize failure event", e);
        }
    }
}
