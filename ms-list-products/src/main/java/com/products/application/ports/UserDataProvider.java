package com.products.application.ports;

import com.products.presentation.dto.ProductDto;
import com.products.domain.aggregate.user.User;
import java.util.List;

public interface UserDataProvider {
  User findUserByUserName(String u);
  List<ProductDto> findAllProducts();
  ProductDto getProductById(int id);
  void updateProduct(int id, ProductDto products);

}
