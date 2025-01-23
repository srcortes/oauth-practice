package com.products.presentation.queries;


import com.products.application.ports.ProductCasePort;
import com.products.lib.response.ProductResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductQueriesController implements OperationQuerieController{

  private final ProductCasePort productUseCase;

  @Override
  public ResponseEntity<List<ProductResponse>> getProducts() {
    return ResponseEntity.ok(productUseCase.getProducts());
  }
  @Override
  public ResponseEntity<ProductResponse> getProductById(int id) {
    return ResponseEntity.ok(productUseCase.getProductById(id));
  }
}
