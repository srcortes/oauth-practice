package com.products.application.ports;

import com.products.lib.response.ProductResponse;
import java.util.List;

public interface QueriesProductCasePort {
  List<ProductResponse> getProducts();

  ProductResponse getProductById(int id);

}
