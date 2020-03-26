package org.demo.shopping.productmanagement.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A Branch.
 */

@Entity
@Data
@NoArgsConstructor
public class Branch extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    private String branchCode;

    @NotNull
    private String name;

    private String description;

    public Branch(String branchCode, String name) {
        this.branchCode = branchCode;
        this.name = name;
    }

}
