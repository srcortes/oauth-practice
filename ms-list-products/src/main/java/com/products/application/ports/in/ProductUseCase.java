package com.products.application.ports.in;


import com.data.domain.products.ProductDto;
import com.products.domain.aggregate.user.User;
import java.util.List;

public interface ProductUseCase {
  List<ProductDto> getProducts();

  ProductDto getProductById(int id);

  void updateProduct(int id, ProductDto products);

}
