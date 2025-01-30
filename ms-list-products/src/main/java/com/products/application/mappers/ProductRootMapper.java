package com.products.application.mappers;

import com.products.application.ports.ProductListener;
import com.products.domain.aggregate.Producto;

import com.products.infrastructure.entities.ProductoEntity;
import com.products.lib.response.ProductResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRootMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "price", target = "price")
  @Mapping(source = "currency", target = "currency")
  ProductResponse toProductResponse(Producto producto);

  List<ProductResponse> toListProductResponse(List<Producto> productos);
  List<Producto> toListProductAggregate(List<ProductoEntity> productos);


}
