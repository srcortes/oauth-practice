package com.products.domain.aggregate;


import com.products.domain.aggregate.entities.Authorities;
import com.products.domain.aggregate.values.Encryption;
import java.util.List;
import lombok.Data;

@Data
public class User {
  private Integer id;

  private String username;

  private String password;

  private Encryption algorithm;

  private List<Authorities> authorities;

}
