package com.products.application.listeners;


import com.products.domain.aggregate.Producto;
import com.products.infrastructure.events.EventListener;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductListener implements EventListener {

  private Producto producto = new Producto();

  private List<Producto> productos = new ArrayList<>();
  @Override
  public void update(String eventType, Producto producto) {
     this.producto = producto;
  }

  @Override
  public void update(String eventType, List<Producto> producto) {
      this.productos = producto;
  }
}
