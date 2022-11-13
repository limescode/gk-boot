package pl.limescode.gkboot.repository;

import org.springframework.stereotype.Repository;
import pl.limescode.gkboot.dto.ProductCreateDto;
import pl.limescode.gkboot.exception.NotFoundException;
import pl.limescode.gkboot.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class ProductRepository {
    private List<Product> products;
    private int counter;
    public static final Integer INITIAL_SIZE = 5;

    public ProductRepository() {
        this.counter = 0;
        this.products = IntStream.rangeClosed(1, INITIAL_SIZE)
                .mapToObj(item -> new Product(nextId(), "Product " + item, BigDecimal.valueOf(item)))
                .collect(Collectors.toList());
    }

    private Long nextId() {
        return (long) counter++;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst().orElseThrow(NotFoundException::new);
    }

    public Product addProduct(ProductCreateDto productDto) {
        var product = new Product(nextId(), productDto.getTitle(), productDto.getPrice());
        products.add(product);
        return product;
    }

}
