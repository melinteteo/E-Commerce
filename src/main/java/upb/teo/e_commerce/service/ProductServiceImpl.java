package upb.teo.e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upb.teo.e_commerce.dto.Product;
import upb.teo.e_commerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // == private fields ==
    private final ProductRepository productRepository;

    // == constructors ==
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> add(List<Product> product) {
        return productRepository.saveAll(product);
    }

    @Override
    public List<Product> fetchProductByName(String productName) {
        return productRepository.findAllByProductNameContaining(productName);
    }

    @Override
    public String buy(Product product) {
        productRepository.delete(product);
        return product.getProductName() + " wurde erfolgreich gelöscht!";
    }
}
