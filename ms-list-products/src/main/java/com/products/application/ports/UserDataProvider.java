package com.products.application.ports;

import com.products.infrastructure.adapter.out.entities.Product;
import com.products.infrastructure.adapter.out.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserDataProvider {
  Optional<User> findUserByUserName(String u);
  List<Product> findAllProducts();
  Optional<Product> getProductById(int id);
  void updateProduct(int id, Product products);

}
