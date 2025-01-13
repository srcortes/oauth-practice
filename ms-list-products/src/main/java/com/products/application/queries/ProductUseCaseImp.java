package com.products.application.queries;

import com.products.presentation.dto.ProductDto;
import com.products.domain.aggregate.user.User;
import com.products.application.ports.UserDataProvider;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductUseCaseImp implements ProductUseCase {
  private final UserDataProvider dataProvider;

  @Override
  public User findUserByUserName(String u) {
    return dataProvider.findUserByUserName(u);
  }

  @Override
  public List<ProductDto> getProducts() {
    return dataProvider.findAllProducts();
  }

  @Override
  public ProductDto getProductById(int id) {
    return dataProvider.getProductById(id);
  }

  @Override
  public void updateProduct(int id, ProductDto products) {
    dataProvider.updateProduct(id, products);
  }
}
