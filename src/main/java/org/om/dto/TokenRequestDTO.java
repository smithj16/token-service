package org.om.dto;

import jakarta.validation.constraints.NotBlank;
import org.om.validation.ValidationGroups;

public class TokenRequestDTO {
    @NotBlank(groups = ValidationGroups.Create.class, message = "account id is required")
    private String accountId;

    @NotBlank(groups = ValidationGroups.Create.class)
    private String type;

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


    @Override
    public String toString() {
        return "TokenRequestDTO{" +
                "accountId='" + accountId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
