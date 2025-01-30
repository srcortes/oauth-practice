package com.products.application.usescases;



import com.products.application.mappers.ProductRootMapper;
import com.products.application.ports.ProductCasePort;
import com.products.application.ports.ProductListener;
import com.products.domain.ports.ProductPort;
import com.products.lib.request.ProductRequest;
import com.products.lib.response.ProductResponse;
import java.util.List;
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
    return productRootMapper.toListProductResponse(productListener.getProductos());
  }



  @Override
  public ProductResponse getProductById(int id) {
     //productPort.getProductById(id);
     return null;
  }

  @Override
  public void updateProduct(int id, ProductRequest products) {


    /*Producto producto = productPort.getProductById(id)
        .orElseThrow(()-> new RuntimeException(PRODUCT_NOT_EXIST));
    producto.setName(products.getName());
    producto.setPrice(products.getPrice());
    productPort.updateProduct(producto);*/
  }

}
