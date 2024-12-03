package com.products.application.usecase;

import com.products.application.dto.ProductsDto;
import java.util.List;

public interface UserUseCase {
  List<ProductsDto> getProducts();

  ProductsDto getProductById(int id);

  void updateProduct(int id, ProductsDto products);

}
