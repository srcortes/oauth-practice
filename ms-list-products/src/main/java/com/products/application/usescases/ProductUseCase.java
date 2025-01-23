package com.products.application.usescases;


import com.products.application.listeners.ProductListener;
import com.products.application.mappers.ProductRootMapper;
import com.products.application.ports.ProductCasePort;
import com.products.domain.ports.ProductPort;
import com.products.lib.dto.ProductDto;
import com.products.lib.response.ProductResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductUseCase implements ProductCasePort {

  private final ProductPort productPort;

  private final ProductRootMapper productRootMapper;

  private final ProductListener productListener;
  @Override
  public List<ProductResponse> getProducts() {
    productPort.findAllProducts();
    return productListener.getProductos().stream()
        .map(p-> {
          ProductResponse productResponse = new ProductResponse();
          productResponse.setName(p.getName());
          return productResponse;
        })
        .collect(Collectors.toList());
  }

  @Override
  public ProductResponse getProductById(int id) {
     productPort.getProductById(id);
     return productRootMapper.toProductResponse(productListener.getProducto());
  }

  @Override
  public void updateProduct(int id, ProductDto products) {
    /*Producto producto = productPort.getProductById(id)
        .orElseThrow(()-> new RuntimeException(PRODUCT_NOT_EXIST));
    producto.setName(products.getName());
    producto.setPrice(products.getPrice());
    productPort.updateProduct(producto);*/
  }
}
