package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;

    @Embedded // this attribute has type of user defined class
    private Name name;

    @ElementCollection
    @CollectionTable(name = "hobbies", // table name is hobbies
            joinColumns = @JoinColumn(
                    name = "member_id", // column member_id in table hobbies
                    referencedColumnName = "id" // column id in table members
            ))
    @Column(name = "name") // column in table hobbies
    private List<String> hobbies;

    @ElementCollection
    @CollectionTable(name = "skills",
            joinColumns = @JoinColumn(
                    name = "member_id",
                    referencedColumnName = "id"
            ))
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    private Map<String, Integer> skills;

    @Transient
    private String fullName;

    @PostLoad
    public void createFullName() {
        fullName = name.getTitle() + " " + name.getFirstName() + " " + name.getMiddleName() + " " + name.getLastName();
    }
}
