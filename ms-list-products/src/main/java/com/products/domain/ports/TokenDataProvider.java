package com.products.domain.ports;

import com.data.entities.token.TokenEntity;
import java.util.Optional;

public interface TokenDataProvider {
  Optional<TokenEntity> getToken(String identifier);

  void saveToken(TokenEntity tokenEntity);
}
