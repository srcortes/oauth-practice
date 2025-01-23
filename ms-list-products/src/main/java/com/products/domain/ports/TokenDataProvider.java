package com.products.domain.ports;


import com.products.domain.aggregate.Token;
import java.util.Optional;

public interface TokenDataProvider {
  Optional<Token> getToken(String identifier);

  void saveToken(Token token);
}
