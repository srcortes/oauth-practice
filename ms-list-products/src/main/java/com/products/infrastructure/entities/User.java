package com.products.infrastructure.entities;

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


@Entity(name = "user")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String username;

  private String password;

  @Enumerated(EnumType.STRING)
  private Encryption algorithm;

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Authorities> authorities;

}
