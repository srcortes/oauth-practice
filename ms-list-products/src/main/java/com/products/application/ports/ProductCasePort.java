package com.products.application.ports;


import com.products.lib.request.ProductRequest;
import com.products.lib.response.ProductResponse;
import java.util.List;

public interface ProductCasePort {
  List<ProductResponse> getProducts();

  ProductResponse getProductById(int id);

  void updateProduct(int id, ProductRequest products);

}
