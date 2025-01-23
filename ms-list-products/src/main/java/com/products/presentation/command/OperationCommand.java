package com.products.presentation.command;



import com.products.lib.request.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface OperationCommand {
  @PutMapping("/updateProduct/{id}")
  ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody ProductRequest products);
}
