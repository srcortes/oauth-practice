package com.products.application.ports.out;


import com.data.domain.products.ProductDto;
import java.util.List;

public interface ProductDataProvider {
  List<ProductDto> findAllProducts();
  ProductDto getProductById(int id);
  void updateProduct(int id, ProductDto products);

}
