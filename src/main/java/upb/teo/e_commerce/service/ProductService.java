package upb.teo.e_commerce.service;

import upb.teo.e_commerce.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> add(List<Product> products);

    List<Product> fetchProductByName(String productName);

    String buy(Product product);
}



