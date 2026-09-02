package org.om.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionAcceptedEvent {

    private String eventType;
    private UUID transactionId;
    private String accountId;
    private String tokentier;
    private LocalDateTime occurredAt;

    public TransactionAcceptedEvent() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getTokentier() {
        return tokentier;
    }

    public void setTokentier(String tokentier) {
        this.tokentier = tokentier;
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
                ", transactionId=" + transactionId +
                ", accountId='" + accountId + '\'' +
                ", tokentier='" + tokentier + '\'' +
                ", occurredAt=" + occurredAt +
                '}';
    }
}
