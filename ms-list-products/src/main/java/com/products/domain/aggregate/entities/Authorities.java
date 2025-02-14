package com.products.domain.aggregate.entities;

import com.products.domain.aggregate.User;
import lombok.Data;

@Data

public class Authorities {

  private Integer id;

  private String name;


  private User user;

}
