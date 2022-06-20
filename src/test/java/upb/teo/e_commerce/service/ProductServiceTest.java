package upb.teo.e_commerce.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import upb.teo.e_commerce.dto.Product;
import upb.teo.e_commerce.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceTest {

    private final ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @BeforeEach
    void setUp() {
        Product product = Product
                .builder()
                .productId(1L)
                .price(500)
                .productName("Lenovo")
                .description("Bester Preis")
                .build();

        Mockito.when(productRepository.findAllByProductNameContaining("Lenovo"))
                .thenReturn(List.of(product));
    }

    @Test
    void fetchProductByName() {
        String productName = "Lenovo";

        List<Product> found = productService.fetchProductByName(productName);

        assertEquals(productName, found.get(0).getProductName());
    }
}