package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepo;
import com.example.product.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product add(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllWithFilter(String filterEncode) {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .filter(product -> !product.getName().matches(filterEncode))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Product> getProductsPage(Pageable pageable) {
        return productRepo.findAll(pageable);
    }
}
