package org.demo.shopping.productmanagement.repository;

import org.demo.shopping.productmanagement.model.Product;
import org.demo.shopping.productmanagement.model.ProductAttribute;
import org.demo.shopping.productmanagement.model.ProductAttributeID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, ProductAttributeID> {

    //List<ProductAttribute> findByProduct(Product product);
}
