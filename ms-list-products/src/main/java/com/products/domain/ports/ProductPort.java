package com.products.domain.ports;



import com.products.domain.aggregate.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductPort {
  void findAllProducts();
  void getProductById(int id);
  void updateProduct(Producto producto);

}
