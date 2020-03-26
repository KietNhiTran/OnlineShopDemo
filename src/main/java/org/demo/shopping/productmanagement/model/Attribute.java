package org.demo.shopping.productmanagement.model;


import lombok.*;
import org.demo.shopping.productmanagement.model.enumeration.AttributeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A Attribute.
 */

@Entity
@Data
@NoArgsConstructor
public class Attribute extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AttributeType type;

    @NotNull
    private String unit;


    public Attribute(String name, AttributeType type, String unit) {
        this.name = name;
        this.type = type;
        this.unit = unit;
    }
}
