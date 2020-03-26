package org.demo.shopping.productmanagement.controller;


import org.demo.shopping.productmanagement.model.Branch;
import org.demo.shopping.productmanagement.model.Product;
import org.demo.shopping.productmanagement.model.ProductCatalog;
import org.demo.shopping.productmanagement.model.enumeration.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductIntegrationTest {

    @LocalServerPort
    int randomServerPort;


    private ResponseEntity<Branch> createBranchImpl() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String branchURL = "http://localhost:" + randomServerPort + "/api/v1/productmanagement/branches";
        URI uri = new URI(branchURL);

        Branch branch = new Branch();
        branch.setBranchCode("MG");
        branch.setName("MANGO");
        branch.setDescription("Luxury branch in US");
        ResponseEntity<Branch> result = restTemplate.postForEntity(uri, branch, Branch.class);
        return  result;
    }

    private ResponseEntity<ProductCatalog> createCatalogImpl() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String productCatalogURL = "http://localhost:" + randomServerPort + "/api/v1/productmanagement/productcatalogs";
        URI uri = new URI(productCatalogURL);

        ProductCatalog cat = new ProductCatalog();
        cat.setName("T-SHIRT");
        cat.setProductCatalogCode("T-SHIRT");
        ResponseEntity<ProductCatalog> result = restTemplate.postForEntity(uri, cat, ProductCatalog.class);
        return  result;
    }

    private ResponseEntity<Product> createProductImpl(Branch branch, ProductCatalog productCatalog) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String productURL = "http://localhost:" + randomServerPort + "/api/v1/productmanagement/products";
        URI uri = new URI(productURL);

        Product product = new Product();
        product.setBranch(branch);
        product.setCatalog(productCatalog);
        product.setColor(Color.RED);
        product.setName("Lovely summer T-Shirt");
        product.setProductCode("COD1");
        ResponseEntity<Product> result = restTemplate.postForEntity(uri, product, Product.class);
        return result;
    }

    @Test
    public void testCreateBranchSuccess() throws URISyntaxException {


        ResponseEntity<Branch> result = createBranchImpl();
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());

    }



    @Test
    public void testCreateCatalogSuccess() throws URISyntaxException {

        ResponseEntity<ProductCatalog> result = createCatalogImpl();

        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());

    }


    @Test
    public void testCreateProductSuccess() throws URISyntaxException {

        ResponseEntity<Branch> branchResult = createBranchImpl();
        Assertions.assertEquals(200, branchResult.getStatusCodeValue());
        Assertions.assertNotNull(branchResult.getBody());


        ResponseEntity<ProductCatalog> productCatalogResult = createCatalogImpl();
        Assertions.assertEquals(200, productCatalogResult.getStatusCodeValue());
        Assertions.assertNotNull(productCatalogResult.getBody());

        ResponseEntity<Product> result = createProductImpl(
                branchResult.getBody(), productCatalogResult.getBody());

        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertNotNull(result.getBody());

    }
}
