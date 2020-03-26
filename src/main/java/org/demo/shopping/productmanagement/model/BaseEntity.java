package org.demo.shopping.productmanagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @CreationTimestamp
    protected Date createdAt;

    @UpdateTimestamp
    protected Date updatedAt;
}
