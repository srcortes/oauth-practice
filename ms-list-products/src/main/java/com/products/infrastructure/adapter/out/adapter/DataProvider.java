package com.products.infrastructure.adapter.out.adapter;

import com.products.application.dto.Authorities;
import com.products.application.dto.Encryption;
import com.products.application.dto.ProductsDto;
import com.products.application.dto.Users;
import com.products.application.ports.UserDataProvider;
import com.products.infrastructure.adapter.out.entities.Authority;
import com.products.infrastructure.adapter.out.entities.EncryptionAlgorithm;
import com.products.infrastructure.adapter.out.entities.Product;
import com.products.infrastructure.adapter.out.entities.User;
import com.products.infrastructure.adapter.out.repositories.ProductRepository;
import com.products.infrastructure.adapter.out.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataProvider implements UserDataProvider {

  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  @Override
  public Users findUserByUserName(String u) {
       return userRepository.findUserByUsername(u)
        .map(this::convertToUsers).orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  @Override
  public List<ProductsDto> findAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream().map( p -> {
      ProductsDto products1 = new ProductsDto();
      products1.setId(p.getId());
      products1.setName(p.getName());
      //products1.setCurrency(p.getCurrency());
      return products1;
    }).collect(Collectors.toList());
  }

  @Override
  public ProductsDto getProductById(int id) {
    return productRepository.findById(id).map(this::convertToProducts)
        .orElseThrow(() -> new RuntimeException("Product not found"));
  }

  @Override
  public void updateProduct(int id, ProductsDto products) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    product.setName(products.getName());
    product.setPrice(products.getPrice());
    productRepository.save(product);
  }

  private ProductsDto convertToProducts(Product product) {
    ProductsDto newProduct = new ProductsDto();
    newProduct.setId(product.getId());
    newProduct.setName(product.getName());
    return newProduct;
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

  private Users convertToUsers(User user) {
    System.out.println(user);
    Users users = new Users();
    users.setId(user.getId());
    users.setUsername(user.getUsername());
    users.setPassword(user.getPassword());
    users.setAuthorities(getAuthorities(user.getAuthorities()));
    users.setAlgorithm(getEncryption(user.getAlgorithm()));
    return users;
  }

  private Encryption getEncryption(EncryptionAlgorithm encryptionAlgorithm){
    return Encryption.valueOf(encryptionAlgorithm.toString());
  }


}
