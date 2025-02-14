package com.products.presentation.interfaces;



import com.products.lib.request.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface Operation {
  @PutMapping("/updateProduct/{id}")
  ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody ProductRequest products);

}
