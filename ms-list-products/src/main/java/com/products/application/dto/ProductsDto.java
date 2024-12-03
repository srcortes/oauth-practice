package com.products.application.dto;

import com.products.application.dto.Currencies;
import lombok.Data;

@Data
public class ProductsDto {
  private Integer id;
  private String name;
  private double price;
  private Currencies currency;
}
