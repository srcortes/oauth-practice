package com.products.domain.ports;



import com.products.infrastructure.entities.UserEntity;
import java.util.Optional;

public interface UserDataProvider {
  Optional<UserEntity> findUserByUserName(String u);

}
