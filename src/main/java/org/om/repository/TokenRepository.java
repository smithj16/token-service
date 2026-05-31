package org.om.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.om.model.Token;

@ApplicationScoped
public class TokenRepository implements PanacheRepositoryBase<Token, Long> {
}
