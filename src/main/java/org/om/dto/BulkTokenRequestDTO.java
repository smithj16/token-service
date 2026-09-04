package org.om.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.om.validation.ValidationGroups;

import java.util.List;

public class BulkTokenRequestDTO {
    @NotEmpty(groups = {ValidationGroups.Create.class}, message = "token list must not be empty")
    private List<TokenRequestDTO> tokens;

    public List<TokenRequestDTO> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenRequestDTO> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "BulkTokenRequestDTO{" +
                "tokens=" + tokens +
                '}';
    }
}
