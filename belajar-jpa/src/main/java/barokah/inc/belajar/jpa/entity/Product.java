package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
//    @Column(name = "brand_id", insertable = false, updatable = false)
//    private String brandId; // no need this field again
    private String name;
    private Double price;
    private String description;
    @ManyToOne(
            fetch = FetchType.LAZY // do not join table brand when query this (product) table
    )
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand; // use this field instead
    @ManyToMany(mappedBy = "likes")
    private Set<User> likedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
