package com.products.domain.ports;



import com.products.infrastructure.entities.User;
import java.util.Optional;

public interface UserDataProvider {
  Optional<User> findUserByUserName(String u);

}
