package org.om.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.om.model.Token;

import java.util.Optional;

@ApplicationScoped
public class TokenRepository implements PanacheRepositoryBase<Token, Long> {
    public Token findByAccountId(String accountId){
        return find("accountId", accountId).firstResult();
    }
}
