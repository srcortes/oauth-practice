package com.data.domain.products;

import lombok.Data;

@Data
public class ProductDto {
  private Integer id;
  private String name;
  private double price;
  private CurrenciesDTO currency;
}
