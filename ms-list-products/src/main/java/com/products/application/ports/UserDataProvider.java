package com.products.application.ports;

import com.products.application.dto.ProductsDto;
import com.products.application.dto.Users;
import java.util.List;

public interface UserDataProvider {
  Users findUserByUserName(String u);
  List<ProductsDto> findAllProducts();

  ProductsDto getProductById(int id);

  void updateProduct(int id, ProductsDto products);

}
