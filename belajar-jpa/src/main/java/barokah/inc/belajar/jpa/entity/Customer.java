package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    @Column(name = "primary_email") // column name different with field name
    private String primaryEmail;
    private Boolean married;
    private Byte age;
    @Enumerated(EnumType.STRING) // this annotation is mandatory for enum field
    private CustomerType type;
    @Transient // mark this attribute is not table column
    private String fullName;

//    Note : all types must be object
}
