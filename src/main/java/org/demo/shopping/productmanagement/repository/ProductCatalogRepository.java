package org.demo.shopping.productmanagement.repository;

import org.demo.shopping.productmanagement.model.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {

}
