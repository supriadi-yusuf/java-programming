package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("VIP")
@Data
@NoArgsConstructor
public class VicePresident extends Employee{
    @Column(name = "total_manager")
    private Integer total_Manager;
}
