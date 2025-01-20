package com.products.application.usescases;


import com.data.domain.products.ProductDto;
import com.products.application.ports.in.ProductUseCase;
import com.products.domain.aggregate.user.User;
import com.products.application.ports.out.ProductDataProvider;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductUseCaseImp implements ProductUseCase {
  private final ProductDataProvider dataProvider;
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
