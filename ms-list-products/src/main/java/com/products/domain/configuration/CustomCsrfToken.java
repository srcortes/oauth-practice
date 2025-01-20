package com.products.domain.configuration;

import com.data.entities.token.TokenEntity;
import com.products.domain.ports.TokenDataProvider;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

@AllArgsConstructor
public class CustomCsrfToken implements CsrfTokenRepository {

  private final TokenDataProvider tokenDataProvider;

  @Override
  public CsrfToken generateToken(HttpServletRequest request) {
    String uuid = UUID.randomUUID().toString();
    return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
  }

  @Override
  public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
    String identifier = request.getHeader("X-IDENTIFIER");
    Optional<TokenEntity> existingToken =  tokenDataProvider.getToken(identifier);
    if(existingToken.isPresent()){
      TokenEntity entity = existingToken.get();
      entity.setToken(token.getToken());
    }else{
      TokenEntity tokenEntity = new TokenEntity();
      tokenEntity.setToken(token.getToken());
      tokenEntity.setIdentifier(identifier);
      tokenDataProvider.saveToken(tokenEntity);
    }

  }

  @Override
  public CsrfToken loadToken(HttpServletRequest request) {
    String identifier = request.getHeader("X-IDENTIFIER");
    Optional<TokenEntity> existingToken = tokenDataProvider.getToken(identifier);
    return existingToken.map(tokenEntity -> new DefaultCsrfToken("X-CSRF-TOKEN","_csrf", tokenEntity.getToken()))
        .orElse(null);
  }
}
