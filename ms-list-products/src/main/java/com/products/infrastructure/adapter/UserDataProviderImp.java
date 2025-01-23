package com.products.infrastructure.adapter;


import com.products.domain.aggregate.User;
import com.products.domain.ports.UserDataProvider;
import com.products.infrastructure.repositories.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDataProviderImp implements UserDataProvider {
  private final UserRepository userRepository;
  @Override
  public Optional<User> findUserByUserName(String u) {
    return userRepository.findUserByUsername(u);
  }


}
