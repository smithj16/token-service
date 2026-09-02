package org.om.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.om.dto.TransactionAcceptedEvent;
import org.om.exception.TokenCreationFailedException;
import org.om.service.TokenProvisionService;

@ApplicationScoped
public class TokenProvisionConsumer {

    @Inject
    TokenProvisionService tokenProvisionService;

    @Inject
    ObjectMapper objectMapper;

    @Incoming("transaction-events")
    public void consume(String payload) {
        try {
            TransactionAcceptedEvent event = objectMapper.readValue(payload, TransactionAcceptedEvent.class);

            if (event.getTransactionId() == null) {
                Log.warn("Received event with null transactionId, skipping: eventType=" + event.getEventType());
                return;
            }

            tokenProvisionService.provision(event);
            Log.info("Token provisioned for transactionId: " + event.getTransactionId());
        } catch (JsonProcessingException e) {
            Log.error("Failed to deserialize transaction event payload", e);
            throw new TokenCreationFailedException(e.toString());
        } catch (Exception e) {
            Log.error("Error processing transaction event", e);
            throw new TokenCreationFailedException(e.toString());
        }
    }
}
