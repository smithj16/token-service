package org.om.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.om.model.TokenRedemption;

import java.util.UUID;

@ApplicationScoped
public class TokenRedemptionRepository implements PanacheRepositoryBase<TokenRedemption, Long> {

    public boolean existsByEventId(UUID eventId) {
        return count("eventId", eventId) > 0;
    }

    public void saveByEventId(Long tokenId, UUID eventId) {
        TokenRedemption redemption = new TokenRedemption();
        redemption.setTokenId(tokenId);
        redemption.setEventId(eventId);
        persist(redemption);
    }
}
