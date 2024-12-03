package com.products.application.usecase;

import com.products.application.dto.ProductsDto;
import com.products.infrastructure.adapter.out.adapter.DataProvider;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserUseCaseImp implements UserUseCase{
  private final DataProvider dataProvider;

  @Override
  public List<ProductsDto> getProducts() {
    return dataProvider.findAllProducts();
  }

  @Override
  public ProductsDto getProductById(int id) {
    return dataProvider.getProductById(id);
  }

  @Override
  public void updateProduct(int id, ProductsDto products) {
    dataProvider.updateProduct(id, products);
  }
}
