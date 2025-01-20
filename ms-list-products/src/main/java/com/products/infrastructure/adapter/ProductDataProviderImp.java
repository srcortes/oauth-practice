package com.products.infrastructure.adapter;


import com.data.domain.products.ProductDto;
import com.data.entities.users.Authority;
import com.data.entities.users.EncryptionAlgorithm;
import com.products.application.ports.out.ProductDataProvider;
import com.products.domain.aggregate.user.Authorities;
import com.products.domain.aggregate.user.Encryption;
import com.products.domain.ports.UserDataProvider;
import com.products.infrastructure.repositories.TokenRepository;
import com.products.domain.aggregate.user.User;
import com.products.infrastructure.repositories.ProductRepository;
import com.products.infrastructure.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductDataProviderImp implements ProductDataProvider {


  private final ProductRepository productRepository;
  private final TokenRepository tokenRepository;


  @Override
  public List<ProductDto> findAllProducts() {
    return productRepository.findAll().stream().map( product -> {
      ProductDto productsDto = new ProductDto();
      productsDto.setId(product.getId());
      productsDto.setName(product.getName());
      productsDto.setPrice(product.getPrice());
      return productsDto;
    }).toList();
  }

  @Override
  public ProductDto getProductById(int id) {
    return productRepository.findById(id)
        .map(product -> {
          ProductDto productsDto = new ProductDto();
          productsDto.setId(product.getId());
          productsDto.setName(product.getName());
          productsDto.setPrice(product.getPrice());
          return productsDto;
        }).orElseThrow(() -> new RuntimeException("Product not found"));
  }

  @Override
  public void updateProduct(int id, ProductDto products) {
    productRepository.findById(id)
        .map(product1 -> {
          product1.setName(products.getName());
          product1.setPrice(products.getPrice());
          return product1;
        }).ifPresentOrElse(productRepository::save,
            () ->{
              throw new RuntimeException("Product not found");
            }
        );
  }


}
