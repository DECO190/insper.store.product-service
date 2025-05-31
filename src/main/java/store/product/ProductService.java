package store.product;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(ProductIn productIn) {
        Product product = Product.builder()
            .name(productIn.name())
            .price(productIn.price())
            .unit(productIn.unit())
            .build();

        if (product.name() == null || product.price() == null || product.unit() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product data");
        }

        Product savedProduct = productRepository.save(new ProductModel(product)).to();

        return savedProduct;
    }

    public List<Product> findAll() {
        return StreamSupport
            .stream(productRepository.findAll().spliterator(), false)
            .map(ProductModel::to)
            .toList();
    }

    public Product findById(String id) {
        if (id == null || id.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product ID");
        }

        ProductModel prod = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        return prod.to();
    }

    public void deleteById(String id) {
        if (id == null || id.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid product ID");
        }

        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }

        productRepository.deleteById(id);
    }
}
