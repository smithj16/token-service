package org.om.mapper;

import org.om.dto.TokenRequestDTO;
import org.om.dto.TokenResponseDTO;
import org.om.model.Token;

public class TokenMapper {

    public static Token toToken(TokenRequestDTO tokenRequestDTO){
         Token token = new Token();
         token.setAccountId(tokenRequestDTO.getAccountId());
         token.setType(tokenRequestDTO.getType());
         return token;
    }

    public static TokenResponseDTO toTokenResponseDTO(Token token){
        TokenResponseDTO tokenResponseDTO = new TokenResponseDTO();
        tokenResponseDTO.setId(token.getId());
        tokenResponseDTO.setAccountId(token.getAccountId());
        tokenResponseDTO.setDuration(token.getDuration());
        tokenResponseDTO.setType(token.getType());
        tokenResponseDTO.setRedeemed(token.isRedeemed());
        tokenResponseDTO.setCreatedAt(token.getCreatedAt().toString());
        tokenResponseDTO.setRedeemedAt(token.getRedeemedAt().toString());

        return tokenResponseDTO;
    }
}
