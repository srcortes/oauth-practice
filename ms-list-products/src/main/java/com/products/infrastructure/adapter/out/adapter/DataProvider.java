package com.products.infrastructure.adapter.out.adapter;


import com.products.application.ports.UserDataProvider;
import com.products.infrastructure.adapter.out.entities.Product;
import com.products.infrastructure.adapter.out.entities.User;
import com.products.infrastructure.adapter.out.repositories.ProductRepository;
import com.products.infrastructure.adapter.out.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataProvider implements UserDataProvider {

  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  @Override
  public Optional<User> findUserByUserName(String u) {
    return userRepository.findUserByUsername(u);
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> getProductById(int id) {
    return productRepository.findById(id);
  }

  @Override
  public void updateProduct(int id, Product products) {
    products.setName(products.getName());
    products.setPrice(products.getPrice());
    productRepository.save(products);
  }
}
