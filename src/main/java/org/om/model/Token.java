package org.om.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;
import java.util.Objects;

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
    @Column(name = "type")
    private String type;

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

    @NotNull
    @Column(name = "redeemedAt")
    private LocalDateTime redeemedAt;

    public Token(){
        this.createdAt = LocalDateTime.now();
        this.redeemed = false;
        this.redeemedAt = LocalDateTime.now();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return duration == token.duration && redeemed == token.redeemed && Objects.equals(id, token.id) && Objects.equals(accountId, token.accountId) && Objects.equals(type, token.type) && Objects.equals(createdAt, token.createdAt) && Objects.equals(redeemedAt, token.redeemedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, type, duration, createdAt, redeemed, redeemedAt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                ", createdAt=" + createdAt +
                ", redeemed=" + redeemed +
                ", redeemedAt=" + redeemedAt +
                '}';
    }
}
