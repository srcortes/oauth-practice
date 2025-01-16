package com.products.infrastructure.repositories;


import com.data.entities.token.TokenEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {
  Optional<TokenEntity> findTokenByIdentifier(String identifier);
}
