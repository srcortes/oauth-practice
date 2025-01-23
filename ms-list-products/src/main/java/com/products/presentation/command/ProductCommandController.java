package com.products.presentation.command;

import com.products.application.ports.ProductCasePort;

import com.products.lib.request.ProductRequest;
import com.products.presentation.mappers.ProductRequestMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class ProductCommandController implements OperationCommand {

  private final ProductCasePort productUseCase;

  private final ProductRequestMapper requestMapper;

  @Override
  public ResponseEntity<Void> updateProduct(int id, ProductRequest products) {
    productUseCase.updateProduct(id, requestMapper.toProductDto(products));
    return ResponseEntity.accepted().build();
  }
}
