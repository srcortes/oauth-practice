package com.products.presentation;

import com.products.presentation.dto.ProductDto;
import com.products.application.queries.ProductUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class ProductController implements Operation {

  private final ProductUseCase productUseCase;
  @Override
  public ResponseEntity<List<ProductDto>> getProducts() {
    return ResponseEntity.ok(productUseCase.getProducts());
  }

  @Override
  public ResponseEntity<ProductDto> getProductById(int id) {
    return ResponseEntity.ok(productUseCase.getProductById(id));
  }

  @Override
  public ResponseEntity<Void> updateProduct(int id, ProductDto products) {
    productUseCase.updateProduct(id, products);
    return ResponseEntity.accepted().build();
  }
}
