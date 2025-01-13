package com.products.application.queries;

import com.products.presentation.dto.ProductDto;
import com.products.domain.aggregate.user.User;
import java.util.List;

public interface ProductUseCase {

  User findUserByUserName(String u);
  List<ProductDto> getProducts();

  ProductDto getProductById(int id);

  void updateProduct(int id, ProductDto products);

}
