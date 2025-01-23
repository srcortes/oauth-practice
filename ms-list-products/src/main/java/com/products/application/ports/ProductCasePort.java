package com.products.application.ports;




import com.products.lib.dto.ProductDto;
import com.products.lib.response.ProductResponse;
import java.util.List;

public interface ProductCasePort {
  List<ProductResponse> getProducts();

  ProductResponse getProductById(int id);

  void updateProduct(int id, ProductDto products);

}
