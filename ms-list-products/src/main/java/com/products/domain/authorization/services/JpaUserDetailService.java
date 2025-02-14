package com.products.domain.authorization.services;

import com.products.domain.authorization.provider.CustomUserDetails;
import com.products.domain.mapper.UserMapper;
import com.products.domain.ports.UserDataProvider;
import com.products.infrastructure.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

  private final UserDataProvider dataProvider;

  private final UserMapper userMapper;
  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user = dataProvider.findUserByUserName(username)
        .orElseThrow(()-> new RuntimeException("User not found"));
    return new CustomUserDetails(userMapper.toDTO(user));
  }

}
