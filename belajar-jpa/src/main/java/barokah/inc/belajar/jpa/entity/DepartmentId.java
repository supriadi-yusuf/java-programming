package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class DepartmentId
implements Serializable { // it is mandatory to implement Serializable for embedded primary key / id
    @Column(name = "company_id")
    private String companyId;

    @Column(name = "departement_id")
    private String departementId;
}
