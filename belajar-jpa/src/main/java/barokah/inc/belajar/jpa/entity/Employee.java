package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type")
@DiscriminatorValue("EMPLOYEE")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    private String id;
    private String name;
}

