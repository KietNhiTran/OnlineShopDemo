package org.demo.shopping.productmanagement;

import lombok.extern.slf4j.Slf4j;
import org.demo.shopping.productmanagement.model.*;
import org.demo.shopping.productmanagement.model.enumeration.AttributeType;
import org.demo.shopping.productmanagement.model.enumeration.Color;
import org.demo.shopping.productmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.constraints.NotNull;
import java.util.Date;

@SpringBootApplication()
@Slf4j
public class ProductManagementApplication implements CommandLineRunner {

    @Autowired
    ProductCatalogRepository productCatalogRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    ProductAttributeRepository productAttributeRepository;

    @Autowired
    ProductPriceRepository productPriceRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
        log.info("Application Started !!");
        ProductCatalog cat1 = new ProductCatalog();
        cat1.setName("T-SHIRT");
        cat1.setProductCatalogCode("T-SHIRT");
        productCatalogRepository.save(cat1);
        log.info("cat1 is inserted");

        Branch branch = new Branch();
        branch.setBranchCode("MG");
        branch.setName("MANGO");
        branch.setDescription("Luxury branch in US");
        branchRepository.save(branch);
        log.info("branch1 is inserted");

        Product product = new Product();
        product.setBranch(branch);
        product.setCatalog(cat1);
        product.setColor(Color.RED);
        product.setName("Lovely summer T-Shirt");
        product.setProductCode("COD1");
        productRepository.save(product);

        Attribute newAttribute = new Attribute();
        newAttribute.setName("Length");
        newAttribute.setType(AttributeType.INTEGER);
        newAttribute.setUnit("cm");
        attributeRepository.save(newAttribute);

        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setId(new ProductAttributeID(product.getId(), newAttribute.getId()));
        productAttribute.setValue("100");
        productAttributeRepository.save(productAttribute);

        ProductPrice productPrice = new ProductPrice(100.00, 1, product.getId());
        productPriceRepository.save(productPrice);

	}

}