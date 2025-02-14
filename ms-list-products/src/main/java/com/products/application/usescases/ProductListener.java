package com.products.application.usescases;


import com.products.application.mappers.ProductRootMapper;
import com.products.domain.aggregate.Producto;
import com.products.infrastructure.entities.ProductoEntity;
import com.products.infrastructure.events.ObserverProduct;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class ProductListener implements ObserverProduct {

  private List<Producto> productos;
  private ProductRootMapper productRootMapper;

  @Override
  public void update(List<ProductoEntity> product) {
    productos = new ArrayList<>(productRootMapper.toListProductAggregate(product));
  }
}
