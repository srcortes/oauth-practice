package com.products.domain.aggregate.user;

import java.util.List;
import lombok.Data;

@Data
public class User {

  private Integer Id;

  private String username;

  private String password;

  private Encryption algorithm;

  private List<Authorities> authorities;

}
