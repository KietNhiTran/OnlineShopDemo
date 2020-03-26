package org.demo.shopping.productmanagement.dto;

import lombok.Data;
import org.demo.shopping.productmanagement.model.Branch;
import org.demo.shopping.productmanagement.model.ProductAttribute;
import org.demo.shopping.productmanagement.model.ProductCatalog;
import org.demo.shopping.productmanagement.model.ProductPrice;
import org.demo.shopping.productmanagement.model.enumeration.Color;

import java.util.Set;

@Data
public class ProductDTO {


    private Long id;


    private String productCode;


    private String name;

    private String decription;


    private Color color;

    private Branch branch;


    private ProductCatalog catalog;

    private Set<ProductAttribute> attributes;


    private Set<ProductPrice> prices;


    private ProductPrice currentPrice;

}
