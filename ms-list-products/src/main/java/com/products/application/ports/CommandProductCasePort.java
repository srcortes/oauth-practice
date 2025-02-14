package com.products.application.ports;


import com.products.lib.request.ProductRequest;

public interface CommandProductCasePort {
  void updateProduct(int id, ProductRequest products);

}
