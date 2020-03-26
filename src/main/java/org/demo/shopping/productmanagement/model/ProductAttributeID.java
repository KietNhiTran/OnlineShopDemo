package org.demo.shopping.productmanagement.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * A ProductAttribute composite key
 */


@Embeddable
@Data
@NoArgsConstructor
public class ProductAttributeID implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "attribute_id")
    private Long attributeId;

    public ProductAttributeID( Long productId, Long attributeId) {
        this.productId = productId;
        this.attributeId = attributeId;
    }
}
