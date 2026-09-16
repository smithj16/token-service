package org.om.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.om.dto.TokenTierData;
import org.om.dto.TransactionAcceptedEvent;
import org.om.model.Token;
import org.om.repository.TokenRepository;
import org.om.utils.TokenUtils;

import java.time.LocalDateTime;

@ApplicationScoped
public class TokenProvisionService {

    @Inject
    TokenRepository tokenRepository;

    @Inject
    TokenUtils tokenUtils;

    @Transactional
    public void provision(TransactionAcceptedEvent event) {
        Log.info("Received event: " + event);
        TokenTierData tokenTier = event.getTokenTier();

        provisionToken(event, tokenTier);
    }

    private void provisionToken(TransactionAcceptedEvent event, TokenTierData tokenTier) {
        String tier = tokenTier.getTokenTier();
        int quantity = tokenTier.getQuantity();

        Token existing = tokenRepository.find(
                        "transactionId = ?1 AND tokentier = ?2",
                        event.getTransactionId(), tier)
                .stream().findFirst().orElse(null);

        if (existing != null) {
            return; // redelivered event — idempotent skip for this tier
        }

        Token token = new Token();
        token.setAccountId(event.getAccountId());
        token.setTransactionId(event.getTransactionId());
        token.setTokentier(tier);
        token.setQuantity(quantity);
        token.setCreatedAt(LocalDateTime.now());
        token.setRedeemed(false);

        Log.info(token);
        tokenUtils.setTokenDuration(token);
        tokenRepository.persist(token);
    }

}
