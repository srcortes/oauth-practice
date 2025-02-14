package com.products.presentation.interfaces;

import com.products.lib.response.ProductResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface OperationQueries {
 @GetMapping("/products")
  ResponseEntity<List<ProductResponse>> getProducts();

  @GetMapping("/products/{id}")
  ResponseEntity<ProductResponse> getProductById(@PathVariable int id);

}
