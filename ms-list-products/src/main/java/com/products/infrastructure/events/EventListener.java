package com.products.infrastructure.events;

import com.products.domain.aggregate.Producto;
import com.products.lib.dto.ProductDto;
import java.util.List;

public interface EventListener {
  void update(String eventType, Producto producto);

  void update(String eventType, List<Producto> producto);
}
