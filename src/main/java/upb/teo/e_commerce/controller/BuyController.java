package upb.teo.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upb.teo.e_commerce.dto.Product;
import upb.teo.e_commerce.service.ProductService;

@RestController
@RequestMapping("/buy")
public class BuyController {

    // == private fields ==
    private final ProductService productService;

    // == constructors ==
    @Autowired
    public BuyController(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping
    public String buy(@RequestBody Product product) {
        return productService.buy(product);
    }

}
