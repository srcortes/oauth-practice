package com.products.application.dto;

import java.util.List;
import lombok.Data;

@Data
public class Users {

  private Integer Id;

  private String username;

  private String password;

  private Encryption algorithm;

  private List<Authorities> authorities;

}
