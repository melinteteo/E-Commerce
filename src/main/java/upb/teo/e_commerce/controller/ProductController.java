package upb.teo.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upb.teo.e_commerce.dto.Product;
import upb.teo.e_commerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    // == private fields ==
    private final ProductService productService;

    // == constructors ==
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public List<Product> addProduct(@RequestBody List<Product> products) {
       return productService.add(products);
    }

}
