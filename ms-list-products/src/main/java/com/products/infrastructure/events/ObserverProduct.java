package com.products.infrastructure.events;

import com.products.domain.aggregate.Producto;
import com.products.infrastructure.entities.ProductoEntity;
import java.util.List;

public interface ObserverProduct {
  void update(List<ProductoEntity> producto);
}
