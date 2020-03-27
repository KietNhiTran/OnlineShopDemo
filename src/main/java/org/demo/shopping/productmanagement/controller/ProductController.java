package org.demo.shopping.productmanagement.controller;

import org.demo.shopping.productmanagement.model.Product;
import org.demo.shopping.productmanagement.repository.ProductAttributeRepository;
import org.demo.shopping.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productmanagement")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productRepository.findAll();
       return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    public Product creatProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }


    @GetMapping("/products?name={name}")
    public ResponseEntity<List<Product>> findByName(@RequestParam String name) {
        List<Product> products = productRepository.findByName(name);
        return ResponseEntity.ok(products);
    }


}
