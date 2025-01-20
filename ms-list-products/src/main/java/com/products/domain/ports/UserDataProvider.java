package com.products.domain.ports;

import com.products.domain.aggregate.user.User;

public interface UserDataProvider {
  User findUserByUserName(String u);

}
