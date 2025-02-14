package com.products.application.usescases;

import com.products.application.mappers.ProductRootMapper;
import com.products.application.ports.QueriesProductCasePort;
import com.products.application.ports.ProductPort;
import com.products.lib.response.ProductResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class QueriesProductUseCase implements QueriesProductCasePort {

  private final ProductPort productPort;

  private final ProductRootMapper productRootMapper;

  private final ProductListener productListener;

  @Override
  public List<ProductResponse> getProducts() {
    productPort.findAllProducts();
    return productRootMapper.toListProductResponse(productListener.getProductos());
  }



  @Override
  public ProductResponse getProductById(int id) {
    //productPort.getProductById(id);
    return null;
  }
}
