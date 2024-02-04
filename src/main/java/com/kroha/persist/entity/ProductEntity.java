package com.kroha.persist.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "kroha_product")
@SequenceGenerator(name = "kroha_product_id_seq", sequenceName = "kroha_product_id_seq", allocationSize = 1, initialValue = 1)

public class ProductEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private String cost;
    private byte[] photo;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductEntity other = (ProductEntity) obj;
        return Objects.equals(id, other.getId());
    }
}
