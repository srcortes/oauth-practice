package com.products.presentation;

import com.data.domain.products.ProductDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface  Operation {
  @GetMapping("/products")
  ResponseEntity<List<ProductDto>> getProducts();

  @GetMapping("/products/{id}")
  ResponseEntity<ProductDto> getProductById(@PathVariable int id);

  @PutMapping("/updateProduct/{id}")
  ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody ProductDto products);

}
