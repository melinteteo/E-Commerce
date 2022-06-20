package upb.teo.e_commerce.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import upb.teo.e_commerce.dto.Product;
import upb.teo.e_commerce.service.ProductService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    private Product product;

    @Autowired
    ProductControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    void setUp() {
        product = Product
                .builder()
                .productId(1L)
                .price(500)
                .productName("Lenovo")
                .description("Bester Preis")
                .build();
    }

    @Test
    void addProduct() throws Exception {
        Product inputProduct = Product.builder()
                .productId(1L)
                .price(500)
                .productName("Lenovo")
                .description("Bester Preis")
                .build();

        Mockito.when(productService.add(List.of(inputProduct)))
                .thenReturn(List.of(product));

        mockMvc.perform(post("/product/add").contentType(MediaType.APPLICATION_JSON).content("""
                                [
                                  {
                                    "productName":"Lenovo Laptop",
                                    "price":"500",
                                    "description":"Bester Preis"
                                  }
                                ]"""))
                .andExpect(status().isOk());
    }
}