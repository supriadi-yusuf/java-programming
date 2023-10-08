package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("MANAGER")
@Data
@NoArgsConstructor
public class Manager extends  Employee{
    @Column(name = "total_employee")
    private Integer totalEmployee;
}
