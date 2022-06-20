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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BuyController.class)
class BuyControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    private Product product;

    @Autowired
    BuyControllerTest(MockMvc mockMvc) {
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
    void buy() throws Exception {
        Product inputProduct = Product.builder()
                .productId(1L)
                .price(500)
                .productName("Lenovo")
                .description("Bester Preis")
                .build();

        Mockito.when(productService.buy(inputProduct))
                .thenReturn(product.getProductName() + " wurde erfolgreich gelöscht!");

        mockMvc.perform(delete("/buy")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "productName":"Lenovo",
                            "price":"500",
                            "description":"Bester Preis"
                          }"""))
                .andExpect(status().isOk());
    }
}