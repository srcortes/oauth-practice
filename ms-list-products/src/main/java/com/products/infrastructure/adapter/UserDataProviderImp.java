package com.products.infrastructure.adapter;

import com.data.entities.users.Authority;
import com.data.entities.users.EncryptionAlgorithm;
import com.products.domain.aggregate.user.Authorities;
import com.products.domain.aggregate.user.Encryption;
import com.products.domain.aggregate.user.User;
import com.products.domain.ports.UserDataProvider;
import com.products.infrastructure.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDataProviderImp implements UserDataProvider {
  private final UserRepository userRepository;

  @Override
  public User findUserByUserName(String u) {
    return userRepository.findUserByUsername(u)
        .map(user -> {
          User users = new User();
          users.setId(user.getId());
          users.setUsername(user.getUsername());
          users.setPassword(user.getPassword());
          users.setAuthorities(getAuthorities(user.getAuthorities()));
          users.setAlgorithm(getEncryption(user.getAlgorithm()));
          return users;
        }).orElseThrow(() -> new RuntimeException("User not found"));
  }

  private List<Authorities> getAuthorities(List<Authority> authorities) {
    return authorities.stream()
        .map(this::convertToAuthorities)
        .collect(Collectors.toList());
  }
  private Authorities convertToAuthorities(Authority auth) {
    Authorities authority = new Authorities();
    authority.setId(auth.getId());
    authority.setName(auth.getName());
    return authority;
  }
  private Encryption getEncryption(EncryptionAlgorithm encryptionAlgorithm) {
    return Encryption.valueOf(encryptionAlgorithm.toString());
  }
}
