package org.om.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class Token extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountId")
    @NotNull
    private String accountId;

    @NotNull
    @Column(name = "transactionId", unique = true)
    private UUID transactionId;

    @NotNull
    @Column(name = "tokentier")
    private String tokentier;

    @Min(7)
    @Max(365)
    @NotNull
    @Column(name = "duration")
    private int duration;

    @NotNull
    @Column(name = "createdAt")
    @PastOrPresent
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "redeemed")
    private boolean redeemed;

    @Column(name = "redeemedAt")
    private LocalDateTime redeemedAt;

    public Token(){
        this.createdAt = LocalDateTime.now();
        this.redeemed = false;
        this.redeemedAt = null;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isRedeemed() {
        return redeemed;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }

    public LocalDateTime getRedeemedAt() {
        return redeemedAt;
    }

    public void setRedeemedAt(LocalDateTime redeemedAt) {
        this.redeemedAt = redeemedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return duration == token.duration && redeemed == token.redeemed && Objects.equals(id, token.id) && Objects.equals(accountId, token.accountId) && Objects.equals(transactionId, token.transactionId) && Objects.equals(tokentier, token.tokentier) && Objects.equals(createdAt, token.createdAt) && Objects.equals(redeemedAt, token.redeemedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, transactionId, tokentier, duration, createdAt, redeemed, redeemedAt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", tokentier='" + tokentier + '\'' +
                ", duration=" + duration +
                ", createdAt=" + createdAt +
                ", redeemed=" + redeemed +
                ", redeemedAt=" + redeemedAt +
                '}';
    }
}
