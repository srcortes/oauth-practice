package com.products.presentation.controllers;

import com.products.application.ports.CommandProductCasePort;
import com.products.lib.request.ProductRequest;
import com.products.presentation.interfaces.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;


@AllArgsConstructor
public class ProductController implements Operation {

  private final CommandProductCasePort productUseCase;

  @Override
  public ResponseEntity<Void> updateProduct(int id, ProductRequest products) {
    productUseCase.updateProduct(id, products);
    return ResponseEntity.accepted().build();
  }
}
