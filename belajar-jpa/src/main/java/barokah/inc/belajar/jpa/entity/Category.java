package barokah.inc.belajar.jpa.entity;

import barokah.inc.belajar.jpa.listener.UpdatedAtAware;
import barokah.inc.belajar.jpa.listener.UpdatedAtListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "categories")
@EntityListeners({UpdatedAtListener.class})
@Data
@NoArgsConstructor
public class Category
implements UpdatedAtAware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP) // for java.util.Date and java.util.Calendar
    @Column(name = "created_at")
    private Calendar createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
