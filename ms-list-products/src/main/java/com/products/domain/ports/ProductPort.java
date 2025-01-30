package com.products.domain.ports;



import com.products.domain.aggregate.Producto;

public interface ProductPort {
  void findAllProducts();
  void getProductById(int id);
  void updateProduct(Producto producto);

}
