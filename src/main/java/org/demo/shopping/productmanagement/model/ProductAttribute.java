package org.demo.shopping.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A ProductAttribute.
 */

@Entity
@Data
@NoArgsConstructor
public class ProductAttribute extends BaseEntity {


    @EmbeddedId
    private ProductAttributeID id;

/*
    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("product_id")
    //@JsonIgnoreProperties("attributes")
    @JsonIgnore
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    @MapsId("attribute_id")
    private Attribute attribute;*/


    @NotNull
    @Column
    private String value;

    public ProductAttribute(ProductAttributeID id, String value) {
        this.id = id;
        this.value = value;
    }

}
