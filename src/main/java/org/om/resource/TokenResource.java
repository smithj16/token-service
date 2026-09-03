package org.om.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.reactive.RestResponse;
import org.om.dto.BulkTokenRequestDTO;
import org.om.dto.TokenResponseDTO;
import org.om.service.TokenService;

import java.util.List;
import java.util.UUID;

@Path("api/tokens")
@ApplicationScoped
public class TokenResource {

    @Inject
    TokenService tokenService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "get all tokens",
            description = "get all tokens")
    @APIResponse(responseCode = "200", description = "get all tokens",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<List<TokenResponseDTO>> getAllTokens(){
        return RestResponse.ok(tokenService.getAllTokens());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "get token by id",
            description = "get token by id")
    @APIResponse(responseCode = "200", description = "get token by id",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<TokenResponseDTO> getTokenById(Long id){
        return RestResponse.ok(tokenService.getTokenById(id));
    }

    @GET
    @Path("account/{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "get tokens by account id",
            description = "get tokens by account id")
    @APIResponse(responseCode = "200", description = "get tokens by account id",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<List<TokenResponseDTO>> getTokensByAccountId(String accountId){
        return RestResponse.ok(tokenService.getTokensByAccountId(accountId));
    }

    @GET
    @Path("transaction/{transactionId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(summary = "get tokens by transaction id",
            description = "get all tokens linked to a transaction")
    @APIResponse(responseCode = "200", description = "get tokens by transaction id",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<List<TokenResponseDTO>> getTokensByTransactionId(UUID transactionId){
        return RestResponse.ok(tokenService.getTokensByTransactionId(transactionId));
    }

    @GET
    @Path("account/{accountId}/unredeemed")
    @Transactional
    public RestResponse<List<TokenResponseDTO>> getUnredeemedTokens(String accountId){
        return RestResponse.ok(tokenService.getUnredeemedTokensByAccountId(accountId));
    }



    @POST
    @Path("bulk")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "create multiple tokens",
            description = "create multiple tokens in a single request")
    @APIResponse(responseCode = "201", description = "create multiple tokens",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<List<Long>> buyTokens(@Valid BulkTokenRequestDTO bulkTokenRequestDTO){
        return RestResponse.ok(tokenService.createTokens(bulkTokenRequestDTO.getTokens()));
    }

    @PUT
    @Path("{id}")
    @Transactional
    @Operation(summary = "redeem one token",
            description = "redeem one token")
    @APIResponse(responseCode = "204", description = "redeem one token",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<Void> redeemToken(Long id){
        tokenService.redeemToken(id);
        return RestResponse.noContent();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    @Operation(summary = "delete one token",
            description = "delete one token")
    @APIResponse(responseCode = "204", description = "delete one token",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TokenResponseDTO.class)
            ))
    public RestResponse<Void> deleteToken(Long id){
        tokenService.deleteTokenRecord(id);
        return RestResponse.noContent();
    }

}
