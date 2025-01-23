package com.products.presentation.mappers;



import com.products.lib.dto.ProductDto;
import com.products.lib.request.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "price", target = "price")
  @Mapping(source = "currency", target = "currency")
  ProductDto toProductDto(ProductRequest request);

}
