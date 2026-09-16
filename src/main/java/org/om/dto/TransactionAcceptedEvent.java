package org.om.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionAcceptedEvent {

    private String eventType;
    private UUID eventId;
    private UUID transactionId;
    private String accountId;
    private TokenTierData tokenTier;
    private LocalDateTime occurredAt;

    public TransactionAcceptedEvent() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public TokenTierData getTokenTier() {
        return tokenTier;
    }

    public void setTokenTier(TokenTierData tokenTier) {
        this.tokenTier = tokenTier;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    @Override
    public String toString() {
        return "TransactionAcceptedEvent{" +
                "eventType='" + eventType + '\'' +
                ", eventId=" + eventId +
                ", transactionId=" + transactionId +
                ", accountId='" + accountId + '\'' +
                ", tokenTier=" + tokenTier +
                ", occurredAt=" + occurredAt +
                '}';
    }
}
