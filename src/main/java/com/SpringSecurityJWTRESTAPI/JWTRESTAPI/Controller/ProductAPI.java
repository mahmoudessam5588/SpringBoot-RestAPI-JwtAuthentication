package com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Controller;

import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Entity.Product;
import com.SpringSecurityJWTRESTAPI.JWTRESTAPI.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductAPI {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        return ResponseEntity.created(URI.create("/products/" + productRepository.save(product).getId())).body(productRepository.save(product));

    }

}
