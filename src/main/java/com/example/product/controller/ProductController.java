package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProductByName(@RequestParam(value = "nameFilter")
                                                                  Optional<String> filter,
                                                          @RequestParam Optional<Integer> page,
                                                          @RequestParam Optional<Integer> size) {
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10));
        if (!filter.isPresent()) {
            return new ResponseEntity<>(productService.getProductsPage(pageable), HttpStatus.OK);
        }
        List<Product> productList = productService.getAllWithFilter(filter.get());
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), productList.size());
        Page<Product> productPage = new PageImpl<>(productList.subList(start, end),
                pageable, productList.size());
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }
}
