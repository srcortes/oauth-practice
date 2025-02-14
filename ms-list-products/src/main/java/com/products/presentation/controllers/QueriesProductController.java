package com.products.presentation.controllers;

import com.products.application.ports.QueriesProductCasePort;
import com.products.lib.response.ProductResponse;
import com.products.presentation.interfaces.OperationQueries;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class QueriesProductController implements OperationQueries {

  private final QueriesProductCasePort queriesProductCasePort;

  @Override
  public ResponseEntity<List<ProductResponse>> getProducts() {
    return ResponseEntity.ok(queriesProductCasePort.getProducts());
  }

  @Override
  public ResponseEntity<ProductResponse> getProductById(int id) {
    return null;
  }
}
