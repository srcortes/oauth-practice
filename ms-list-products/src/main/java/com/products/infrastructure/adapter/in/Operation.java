package com.products.infrastructure.adapter.in;

import com.products.application.dto.ProductsDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface  Operation {
  @GetMapping("/products")
  ResponseEntity<List<ProductsDto>> getProducts();

  @GetMapping("/products/{id}")
  ResponseEntity<ProductsDto> getProductById(@PathVariable int id);

  @PutMapping("/updateProduct/{id}")
  ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody ProductsDto products);

}
