package com.products.domain.aggregate;

import com.products.domain.aggregate.entities.Authorities;
import com.products.domain.aggregate.values.Encryption;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

public class User {
  private Integer id;

  private String username;

  private String password;

  private Encryption algorithm;

  private List<Authorities> authorities;

}
