package org.om.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.om.dto.TokenRequestDTO;
import org.om.dto.TokenResponseDTO;
import org.om.exception.TokenCreationFailedException;
import org.om.exception.TokenRecordNotFoundException;
import org.om.exception.TokenRedeemedException;
import org.om.mapper.TokenMapper;
import org.om.model.Token;
import org.om.repository.TokenRepository;
import org.om.utils.TokenUtils;

import io.quarkus.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TokenService {
    private static final Logger log = LoggerFactory.getLogger(TokenService.class);
    @Inject
    TokenRepository tokenRepository;

    @Inject
    TokenUtils tokenUtils;

    public List<TokenResponseDTO> getAllTokens(){
        return tokenRepository.findAll().stream()
                .map(TokenMapper::toTokenResponseDTO)
                .toList();
    }

    public TokenResponseDTO getTokenById(Long id){
        Optional<Token> token = tokenRepository.findByIdOptional(id);

        if(token.isEmpty())
            throw new TokenRecordNotFoundException("token with the id: " + id + " not found.");

        return TokenMapper.toTokenResponseDTO(token.get());
    }

    public List<TokenResponseDTO> getTokensByAccountId(String accountId){
        return tokenRepository.find("accountId", accountId)
                .stream()
                .map(TokenMapper::toTokenResponseDTO)
                .toList();
    }

    public Long createToken(TokenRequestDTO tokenRequestDTO){
        try{
            Token token = TokenMapper.toToken(tokenRequestDTO);
            tokenUtils.setTokenDuration(token);
            tokenRepository.persist(token);
            return tokenRepository.findByAccountId(tokenRequestDTO.getAccountId()).getId();
        }catch(Exception ex){
            Log.error(ex.getMessage());
            throw new TokenCreationFailedException("failed to create token.");
        }
    }

    public List<Long> createTokens(List<TokenRequestDTO> tokenRequestList){
        List<Long> successful = new ArrayList<>();

        tokenRequestList.stream()
                .map(TokenMapper::toToken)
                .map(tokenUtils::setTokenDuration)
                .forEach(token -> {
                    try{
                      tokenRepository.persist(token);
                      successful.add(token.getId());
                    }catch(Exception ex){
                        Log.warn("Skipping invalid token request: " + token.toString() + " - " + ex.getMessage());
                    }
                });

        if(successful.isEmpty())
            throw new TokenCreationFailedException("all token requests failed validation or creation.");

        return successful;
    }

    public void redeemToken(Long id){
        Optional<Token> optionalToken = tokenRepository.findByIdOptional(id);
        if(optionalToken.isEmpty())
            throw new TokenRecordNotFoundException("token with the id: " + id + " not found.");

        if(optionalToken.get().isRedeemed())
            throw new TokenRedeemedException("token with the id: " + id + " could not be redeem.");

        Token token = optionalToken.get();
        token.setRedeemed(true);
        token.setRedeemedAt(LocalDateTime.now());
        tokenRepository.persist(token);
    }

    public void deleteTokenRecord(Long id){
        Optional<Token> optionalToken = tokenRepository.findByIdOptional(id);
        if(optionalToken.isEmpty())
            throw new TokenRecordNotFoundException("token with the id: " + id + " not found.");

        tokenRepository.deleteById(id);
    }
}
