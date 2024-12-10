package com.products.domain.service;

import com.products.application.dto.Authorities;
import com.products.application.dto.Encryption;
import com.products.application.dto.Users;
import com.products.application.ports.UserDataProvider;
import com.products.domain.entities.CustomUserDetails;
import com.products.infrastructure.adapter.out.entities.Authority;
import com.products.infrastructure.adapter.out.entities.EncryptionAlgorithm;
import com.products.infrastructure.adapter.out.entities.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {
  private final UserDataProvider dataProvider;

  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return dataProvider.findUserByUserName(username)
            .map(user -> new CustomUserDetails(convertToUsers(user)))
        .orElseThrow(()->  new UsernameNotFoundException("Error during authentication"));
  }
  private Users convertToUsers(User user) {
    Users users = new Users();
    users.setId(user.getId());
    users.setUsername(user.getUsername());
    users.setPassword(user.getPassword());
    users.setAuthorities(getAuthorities(user.getAuthorities()));
    users.setAlgorithm(getEncryption(user.getAlgorithm()));
    return users;
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
