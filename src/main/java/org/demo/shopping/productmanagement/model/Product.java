package org.demo.shopping.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo.shopping.productmanagement.model.enumeration.Color;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


/**
 * A Product.
 */
@Data
@Entity
@NoArgsConstructor
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    private String productCode;

    @NotNull
    private String name;

    private String decription;

    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToOne(targetEntity = Branch.class, fetch = FetchType.EAGER)
    @NotNull
    private Branch branch;

    @ManyToOne(targetEntity = ProductCatalog.class, fetch = FetchType.EAGER)
    @NotNull
    private ProductCatalog catalog;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductAttribute> attributes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductPrice> prices;

    @Transient
    private ProductPrice currentPrice;


    public Product(@NotNull String productCode, @NotNull String name, Color color, @NotNull Branch branch, @NotNull ProductCatalog catalog) {
        this.productCode = productCode;
        this.name = name;
        this.color = color;
        this.branch = branch;
        this.catalog = catalog;
    }

    public void addAttribute(Attribute attribute, String value) {
        if (getAttributes() == null) {
            this.attributes = new HashSet<>();
        }

        ProductAttributeID productAttributeID = new ProductAttributeID(this.id, attribute.getId());
        ProductAttribute productAttribute = new ProductAttribute(productAttributeID, value);
        this.attributes.add(productAttribute);
    }

    public ProductPrice getCurrentPrice() {
        if (getPrices() == null || getPrices().isEmpty()) {
            return null;
        }

        if (this.currentPrice == null) {
            Set<ProductPrice> effectedPrice = this.prices.stream().filter(p -> p.getEffectiveDate().compareTo(new Date()) <= 0).collect(Collectors.toSet());
            currentPrice = Collections.max(effectedPrice, new LastEffectivePriceComparator());
        }
        return currentPrice;
    }

    private class LastEffectivePriceComparator implements Comparator<ProductPrice> {
        public int compare(ProductPrice a, ProductPrice b) {
            return a.getEffectiveDate().compareTo(b.getEffectiveDate());
        }
    }
}
