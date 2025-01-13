package com.products.domain.service;


import com.products.application.ports.UserDataProvider;
import com.products.domain.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

  private final UserDataProvider dataProvider;
  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new CustomUserDetails(dataProvider.findUserByUserName(username));
  }
}
