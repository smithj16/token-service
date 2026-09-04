package org.om.dto;

import jakarta.validation.constraints.NotBlank;
import org.om.validation.ValidationGroups;

import java.util.UUID;

public class TokenRequestDTO {
    @NotBlank(groups = ValidationGroups.Create.class, message = "account id is required")
    private String accountId;

    @NotBlank(groups = ValidationGroups.Create.class, message = "transaction id is required")
    private UUID transactionId;

    @NotBlank(groups = ValidationGroups.Create.class, message = "tokentier is required")
    private String tokentier;

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


    @Override
    public String toString() {
        return "TokenRequestDTO{" +
                "accountId='" + accountId + '\'' +
                ", transactionId=" + transactionId + '\'' +
                ", tokentier='" + tokentier + '\'' +
                '}';
    }
}
