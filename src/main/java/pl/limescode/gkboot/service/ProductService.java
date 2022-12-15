package pl.limescode.gkboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.limescode.gkboot.dto.ProductCreateDto;
import pl.limescode.gkboot.model.Product;
import pl.limescode.gkboot.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProduct(Long id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }

    public Product createProduct(ProductCreateDto productDto) {
        return productRepository.addProduct(productDto);
    }

}
