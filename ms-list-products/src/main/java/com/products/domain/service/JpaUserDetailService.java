package com.products.domain.service;


import com.products.application.ports.out.ProductDataProvider;
import com.products.domain.CustomUserDetails;
import com.products.domain.ports.UserDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

  private final UserDataProvider dataProvider;
  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new CustomUserDetails(dataProvider.findUserByUserName(username));
  }
}
