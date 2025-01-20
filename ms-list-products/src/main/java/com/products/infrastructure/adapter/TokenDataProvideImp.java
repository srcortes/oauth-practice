package com.products.infrastructure.adapter;

import com.data.entities.token.TokenEntity;
import com.products.domain.ports.TokenDataProvider;
import com.products.infrastructure.repositories.TokenRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TokenDataProvideImp implements TokenDataProvider {
  private final TokenRepository tokenRepository;

  @Override
  public Optional<TokenEntity> getToken(String identifier) {
    return tokenRepository.findTokenByIdentifier(identifier);
  }

  @Override
  public void saveToken(TokenEntity tokenEntity){
    tokenRepository.save(tokenEntity);
  }
}
