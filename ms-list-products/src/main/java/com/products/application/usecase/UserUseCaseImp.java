package com.products.application.usecase;

import com.products.application.dto.ProductsDto;
import com.products.application.ports.UserDataProvider;
import com.products.infrastructure.adapter.out.entities.Product;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserUseCaseImp implements UserUseCase{
  private final UserDataProvider dataProvider;

  @Override
  public List<ProductsDto> getProducts() {
    return dataProvider.findAllProducts().stream().map( product -> {
      ProductsDto productsDto = new ProductsDto();
      productsDto.setId(product.getId());
      productsDto.setName(product.getName());
      productsDto.setPrice(product.getPrice());
      return productsDto;
    }).toList();
  }

  @Override
  public ProductsDto getProductById(int id) {
    return dataProvider.getProductById(id)
        .map(product -> {
          ProductsDto productsDto = new ProductsDto();
          productsDto.setId(product.getId());
          productsDto.setName(product.getName());
          productsDto.setPrice(product.getPrice());
          return productsDto;
        }).orElseThrow(() -> new RuntimeException("Product not found"));
  }

  @Override
  public void updateProduct(int id, ProductsDto products) {
    Product product = dataProvider.getProductById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    product.setName(products.getName());
    product.setPrice(products.getPrice());
    dataProvider.updateProduct(id, product);
  }
}
