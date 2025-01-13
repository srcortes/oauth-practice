package com.products.infrastructure.adapter;


import com.products.domain.aggregate.user.Authorities;
import com.products.domain.aggregate.user.Encryption;
import com.products.infrastructure.repositories.entities.Authority;
import com.products.infrastructure.repositories.entities.EncryptionAlgorithm;
import com.products.presentation.dto.ProductDto;
import com.products.domain.aggregate.user.User;
import com.products.application.ports.UserDataProvider;
import com.products.infrastructure.repositories.ProductRepository;
import com.products.infrastructure.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataProvider implements UserDataProvider {

  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  @Override
  public User findUserByUserName(String u) {
    return userRepository.findUserByUsername(u)
        .map(user -> {
          User users = new User();
          users.setId(user.getId());
          users.setUsername(user.getUsername());
          users.setPassword(user.getPassword());
          users.setAuthorities(getAuthorities(user.getAuthorities()));
          users.setAlgorithm(getEncryption(user.getAlgorithm()));
          return users;
        }).orElseThrow(() -> new RuntimeException("User not found"));
  }

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

  private List<Authorities> getAuthorities(List<Authority> authorities) {
    return authorities.stream()
        .map(this::convertToAuthorities)
        .collect(Collectors.toList());
  }
  private Authorities convertToAuthorities(Authority auth) {
    Authorities authority = new Authorities();
    authority.setId(auth.getId());
    authority.setName(auth.getName());
    return authority;
  }
  private Encryption getEncryption(EncryptionAlgorithm encryptionAlgorithm) {
    return Encryption.valueOf(encryptionAlgorithm.toString());
  }
}
