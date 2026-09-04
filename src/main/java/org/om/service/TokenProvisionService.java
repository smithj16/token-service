package org.om.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.om.dto.TransactionAcceptedEvent;
import org.om.model.Token;
import org.om.repository.TokenRepository;
import org.om.utils.TokenUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TokenProvisionService {

    @Inject
    TokenRepository tokenRepository;

    @Inject
    TokenUtils tokenUtils;

    @Transactional
    public void provision(TransactionAcceptedEvent event) {
        List<Token> existing = tokenRepository.list("transactionId", event.getTransactionId());
        if (!existing.isEmpty()) {
            return; // redelivered event — idempotent skip
        }
        Token token = new Token();
        token.setAccountId(event.getAccountId());
        token.setTransactionId(event.getTransactionId());
        token.setTokentier(event.getTokentier());
        token.setCreatedAt(LocalDateTime.now());
        token.setRedeemed(false);
        tokenUtils.setTokenDuration(token);
        tokenRepository.persist(token);
    }
}
