package com.products.lib.response;

import lombok.Data;

@Data
public class ProductResponse {
  private Integer id;
  private String name;
  private double price;
  private CurrencyResponse currency;
}
