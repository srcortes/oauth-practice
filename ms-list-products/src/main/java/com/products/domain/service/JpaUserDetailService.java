package com.products.domain.service;

import com.products.domain.entities.CustomUserDetails;
import com.products.infrastructure.adapter.out.adapter.DataProvider;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {
  private final DataProvider dataProvider;

  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return Optional.ofNullable(dataProvider.findUserByUserName(username))
        .map(CustomUserDetails::new)
        .orElseThrow(()->  new UsernameNotFoundException("Error during authentication"));
  }
}
