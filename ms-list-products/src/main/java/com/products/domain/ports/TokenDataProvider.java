package com.products.domain.ports;



import com.products.infrastructure.entities.Token;
import java.util.Optional;

public interface TokenDataProvider {
  Optional<Token> getToken(String identifier);

  void saveToken(Token token);
}
