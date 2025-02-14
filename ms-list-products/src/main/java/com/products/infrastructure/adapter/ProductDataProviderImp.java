package com.products.infrastructure.adapter;

import com.products.application.ports.ProductPort;
import com.products.infrastructure.entities.ProductoEntity;
import com.products.infrastructure.events.ManagerObservers;
import com.products.application.usescases.ProductListener;
import com.products.infrastructure.repositories.ProductRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductDataProviderImp implements ProductPort {

  private final ProductRepository productRepository;

  private ManagerObservers eventManager;

  private ProductListener productListener;


  @Override
  public void findAllProducts() {
    List<ProductoEntity> products = productRepository.findAll().stream().toList();
    eventManager.subscribe(productListener);
    eventManager.notify(products);
    eventManager.unsubscribe(productListener);
  }

}
