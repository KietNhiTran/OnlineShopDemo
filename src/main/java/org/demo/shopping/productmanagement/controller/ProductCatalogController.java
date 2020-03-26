package org.demo.shopping.productmanagement.controller;

import org.demo.shopping.productmanagement.model.Branch;
import org.demo.shopping.productmanagement.model.ProductCatalog;
import org.demo.shopping.productmanagement.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productmanagement")
public class ProductCatalogController {

    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @PostMapping("/productcatalogs")
    public ProductCatalog createCatalog(@RequestBody ProductCatalog productCatalog) {
        return productCatalogRepository.save(productCatalog);
    }
}
