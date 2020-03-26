package org.demo.shopping.productmanagement.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A ProductCatalog.
 */
@Data
@Entity
@NoArgsConstructor
public class ProductCatalog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    private String productCatalogCode;

    @NotNull
    private String name;

    private String description;

    public ProductCatalog(String productCatalogCode, String name) {
        this.productCatalogCode = productCatalogCode;
        this.name = name;
    }

}
