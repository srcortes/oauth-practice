package com.products.lib.request;

import com.products.lib.dto.CurrenciesDTO;
import lombok.Data;

@Data
public class ProductRequest {
  private Integer id;
  private String name;
  private double price;
  private CurrenciesDTO currency;

}
