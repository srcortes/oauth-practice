package com.products.infrastructure.adapter;

import com.products.application.listeners.ProductListener;
import com.products.domain.ports.ProductPort;
import com.products.domain.aggregate.Producto;
import com.products.infrastructure.events.EventManager;
import com.products.infrastructure.repositories.ProductRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductDataProviderImp implements ProductPort {

  private final ProductRepository productRepository;

  private final EventManager eventManager;

  private final ProductListener productListener;

  private final String PRODUCT_NOT_EXIST = "Product not exist";
  @Override
  public void findAllProducts() {
    List<Producto> productos = productRepository.findAll().stream().toList();
    productListener.setProductos(productos);
    eventManager.operations("lista procesados");
    //eventManager.subscribe("lista procesados", productListener);
    eventManager.notify("lista procesados", productos);


  }

  @Override
  public void getProductById(int id) {
    Producto producto = productRepository.findById(id)
        .orElseThrow(()-> new RuntimeException(PRODUCT_NOT_EXIST));
    productListener.setProducto(producto);
    eventManager.operations("procesado");
    eventManager.subscribe("procesado", productListener);
    eventManager.notify("procesado", producto);
    eventManager.unsubscribe("procesado", productListener);
  }

  @Override
  public void updateProduct(Producto producto) {
    productRepository.save(producto);
  }

}
