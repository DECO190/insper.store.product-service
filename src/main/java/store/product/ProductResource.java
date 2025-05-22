package store.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductResource implements ProductController {

    @Autowired
    private ProductService accountService;

    @Override
    public ResponseEntity<ProductOut> create(ProductIn accountIn) {
        
        ProductOut created = ProductOut.builder()
            .id("")
            .name("")
            .price(10f)
            .unit("aa")
            .build();


        return ResponseEntity.ok().body(created);
    }

    @Override
    public ResponseEntity<List<ProductOut>> findAll() {
        List<ProductOut> products = List.of(ProductOut.builder()
            .id("")
            .name("")
            .price(10f)
            .unit("aa")
            .build());
        return ResponseEntity.ok().body(products);
    }

    @Override
    public ResponseEntity<ProductOut> getProductById(String id) {
        ProductOut product = ProductOut.builder()
            .id("")
            .name("")
            .price(10f)
            .unit("aa")
            .build();
        return ResponseEntity.ok().body(product);
    }

    @Override
    public ResponseEntity<Void> deleteProductById(String id) {
        return ResponseEntity.ok().build();
    }
}
