package barokah.inc.belajar.jpa.listener;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

import java.time.LocalDateTime;

public class UpdatedAtListener {
    @PostPersist
    @PostUpdate
    public void doUpdate(UpdatedAtAware object){
        object.setUpdatedAt(LocalDateTime.now());
    }
}
