package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "credentials")
@Data
@NoArgsConstructor
public class Credential {
    @Id
    @Column(name = "crd_id")
    private String id;
    private String email;
    private String password;
    @OneToOne // field of table user
    @PrimaryKeyJoinColumn(
            name = "cr_id", // primary key of table credentials
            referencedColumnName = "id" // primary key of table users
    )
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credential that = (Credential) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
