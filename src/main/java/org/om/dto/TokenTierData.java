package org.om.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.om.validation.ValidationGroups;

public class TokenTierData {

    @NotBlank(groups = ValidationGroups.Create.class, message = "tier type is required")
    private String tokentier;

    @Min(value = 1, message = "quantity must be at least 1")
    private int quantity;

    public TokenTierData(String tokenTier, int quantity) {
        this.tokentier = tokenTier;
        this.quantity = quantity;
    }

    public String getTokenTier() {
        return tokentier;
    }

    public void setTokentier(String tokentier) { this.tokentier = tokentier; }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
