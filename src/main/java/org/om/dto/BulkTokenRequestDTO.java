package org.om.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class BulkTokenRequestDTO {
    @NotEmpty(message = "token list must not be empty")
    @Valid
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
