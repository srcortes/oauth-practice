package com.products.presentation.dto;

import com.products.domain.aggregate.user.Currencies;
import lombok.Data;

@Data
public class ProductDto {
  private Integer id;
  private String name;
  private double price;
  private Currencies currency;
}
