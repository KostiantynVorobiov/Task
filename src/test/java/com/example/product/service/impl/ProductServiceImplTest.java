package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepo;
import com.example.product.service.ProductService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {
    private static final String FILTER = "^E.*$";
    ProductRepo productRepo = Mockito.mock(ProductRepo.class);
    ProductService productService = new ProductServiceImpl(productRepo);



    @Test
    void getAllWithFilterTest() {
        Product duru = new Product(1L, "Duru", "Soap");
        Product elseve = new Product(2L, "Elseve", "Shampoo");
        Product elenor = new Product(3L, "Elenor", "Air freshener");
        Product evyBaby = new Product(4L, "Evy Baby", "Diapers");
        Product fairy = new Product(5L, "Fairy", "Dishwashing liquid");
        List<Product> products = List.of(duru, elseve, elenor, evyBaby, fairy);
        when(productRepo.findAll()).thenReturn(products);
        List<Product> expected = List.of(duru, fairy);
        List<Product> actual = productService.getAllWithFilter(FILTER);
        assertEquals(expected, actual);
    }
}