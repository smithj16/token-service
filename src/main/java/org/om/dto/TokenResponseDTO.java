package org.om.dto;

import java.util.UUID;

public class TokenResponseDTO {
    private Long id;
    private String accountId;
    private UUID transactionId;
    private String tokentier;
    private int duration;
    private boolean redeemed;
    private String createdAt;
    private String redeemedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getTokentier() {
        return tokentier;
    }

    public void setTokentier(String tokentier) {
        this.tokentier = tokentier;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isRedeemed() {
        return redeemed;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getRedeemedAt() {
        return redeemedAt;
    }

    public void setRedeemedAt(String redeemedAt) {
        this.redeemedAt = redeemedAt;
    }
}
