package upb.teo.e_commerce.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import upb.teo.e_commerce.dto.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    private final ProductRepository productRepository;
    private final TestEntityManager testEntityManager;

    @Autowired
    ProductRepositoryTest(ProductRepository productRepository, TestEntityManager testEntityManager) {
        this.productRepository = productRepository;
        this.testEntityManager = testEntityManager;
    }

    @BeforeEach
    void setUp() {
        Product product = Product
                .builder()
                .price(500)
                .productName("Lenovo")
                .description("Bester Preis")
                .build();
        testEntityManager.persist(product);
    }

    @Test
    void findAllByProductNameContaining() {
        List<Product> products = productRepository.findAllByProductNameContaining("Lenovo");

        assertEquals(products.get(0).getProductName(), "Lenovo");
    }
}