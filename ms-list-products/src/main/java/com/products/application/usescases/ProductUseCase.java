package com.products.application.usescases;



import com.products.application.ports.CommandProductCasePort;
import com.products.lib.request.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductUseCase implements CommandProductCasePort {


  @Override
  public void updateProduct(int id, ProductRequest products) {


    /*Producto producto = productPort.getProductById(id)
        .orElseThrow(()-> new RuntimeException(PRODUCT_NOT_EXIST));
    producto.setName(products.getName());
    producto.setPrice(products.getPrice());
    productPort.updateProduct(producto);*/
  }

}
