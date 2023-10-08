package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departements")
@Data
@NoArgsConstructor
public class Department {
    @EmbeddedId
    private DepartmentId id;
    private String name;
}
