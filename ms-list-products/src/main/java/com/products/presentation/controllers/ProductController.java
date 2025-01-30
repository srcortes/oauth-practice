package com.products.presentation.controllers;

import com.products.application.ports.ProductCasePort;
import com.products.lib.request.ProductRequest;
import com.products.lib.response.ProductResponse;
import com.products.presentation.interfaces.Operation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;


@AllArgsConstructor
public class ProductController implements Operation {

  private final ProductCasePort productUseCase;

  @Override
  public ResponseEntity<Void> updateProduct(int id, ProductRequest products) {
    productUseCase.updateProduct(id, products);
    return ResponseEntity.accepted().build();
  }

  @Override
  public ResponseEntity<List<ProductResponse>> getProducts() {
    return ResponseEntity.ok(productUseCase.getProducts());
  }

  @Override
  public ResponseEntity<ProductResponse> getProductById(int id) {
    return ResponseEntity.ok(productUseCase.getProductById(id));
  }
}
