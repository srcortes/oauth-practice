package com.products.domain.ports;


import com.products.domain.aggregate.User;
import java.util.Optional;

public interface UserDataProvider {
  Optional<User> findUserByUserName(String u);

}
