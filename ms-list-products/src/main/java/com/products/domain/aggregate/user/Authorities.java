package com.products.domain.aggregate.user;

import lombok.Data;

@Data
public class Authorities {
  private Integer Id;

  private String name;

  private User user;

}
