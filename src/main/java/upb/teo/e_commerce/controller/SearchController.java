package upb.teo.e_commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upb.teo.e_commerce.dto.Product;
import upb.teo.e_commerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    // == private fields ==
    private final ProductService productService;

    // == constructors ==
    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productName}")
    public List<Product> fetchProductByName(@PathVariable String productName) {
        return productService.fetchProductByName(productName);
    }

}
