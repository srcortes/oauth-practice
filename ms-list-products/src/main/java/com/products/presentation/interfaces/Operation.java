package com.products.presentation.interfaces;



import com.products.lib.request.ProductRequest;
import com.products.lib.response.ProductResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface Operation {
  @PutMapping("/updateProduct/{id}")
  ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody ProductRequest products);

  @GetMapping("/products")
  ResponseEntity<List<ProductResponse>> getProducts();

  @GetMapping("/products/{id}")
  ResponseEntity<ProductResponse> getProductById(@PathVariable int id);
}
