package com.products.infrastructure.adapter.in;

import com.products.application.dto.ProductsDto;
import com.products.application.usecase.UserUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class UserController implements Operation {
  private final UserUseCase userUseCase;

  @Override
  public ResponseEntity<List<ProductsDto>> getProducts() {
    return ResponseEntity.ok(userUseCase.getProducts());
  }

  @Override
  public ResponseEntity<ProductsDto> getProductById(int id) {
    return ResponseEntity.ok(userUseCase.getProductById(id));
  }

  @Override
  public ResponseEntity<Void> updateProduct(int id, ProductsDto products) {
    userUseCase.updateProduct(id, products);
    return ResponseEntity.accepted().build();
  }
}
