package org.demo.shopping.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo.shopping.productmanagement.model.enumeration.Currency;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;


/**
 * A ProductPrice.
 */
@Entity
@Data
public class ProductPrice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Transient
    private static final Currency DEFAULT_CURRENCY = Currency.USD;

    @NotNull
    private Double price;

    @NotNull
    private Integer unit;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Currency defaultCurrency;

    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    @Column(name = "product_id")
    private Long productId;

    public ProductPrice(Double price, Integer unit, Long productId) {
        super();

        this.effectiveDate = new Date();
        this.defaultCurrency = DEFAULT_CURRENCY;
        this.price = price;
        this.unit = unit;
        this.productId = productId;
    }

    public ProductPrice() {
        this.effectiveDate = new Date();
        this.defaultCurrency = DEFAULT_CURRENCY;
    }

}
