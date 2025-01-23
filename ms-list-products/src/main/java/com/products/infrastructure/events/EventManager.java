package com.products.infrastructure.events;

import com.products.domain.aggregate.Producto;
import com.products.lib.dto.ProductDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class EventManager {
  Map<String, List<EventListener>> listeners = new HashMap<>();

  public void operations(String... operations) {
    for (String operation : operations) {
      this.listeners.put(operation, new ArrayList<>());
    }
  }

  public void subscribe(String eventType, EventListener listener) {
    List<EventListener> users = listeners.get(eventType);
    users.add(listener);
  }

  public void unsubscribe(String eventType, EventListener listener) {
    List<EventListener> users = listeners.get(eventType);
    users.remove(listener);
  }

  public void notify(String eventType, Producto file) {
    List<EventListener> users = listeners.get(eventType);
    for (EventListener listener : users) {
      listener.update(eventType, file);
    }
  }

  public void notify(String eventType, List<Producto> file) {
    List<EventListener> users = listeners.get(eventType);
    for (EventListener listener : users) {
      listener.update(eventType, file);
    }
  }
}
