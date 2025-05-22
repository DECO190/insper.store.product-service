package store.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductOut create(ProductIn productIn) {
        Product product = Product.builder()
            .name(productIn.name())
            .price(productIn.price())
            .unit(productIn.unit())
            .build();

        Product savedProduct = productRepository.save(new ProductModel(product)).to();

        return ProductParser.to(savedProduct);
    }


}
