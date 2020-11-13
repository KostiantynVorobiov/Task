package com.example.product.service;

import com.example.product.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product add(Product product);

    List<Product> getAllWithFilter(String regex);

    Page<Product> getProductsPage(Pageable pageable);

}
