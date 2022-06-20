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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
class SearchControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private Product product;

    @Autowired
    SearchControllerTest(MockMvc mockMvc) {
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
    void fetchProductByName() throws Exception {

        Mockito.when(productService.fetchProductByName("Lenovo"))
                .thenReturn(List.of(product));

        mockMvc.perform(get("/search/Lenovo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productName")
                        .value(product.getProductName()));
    }
}