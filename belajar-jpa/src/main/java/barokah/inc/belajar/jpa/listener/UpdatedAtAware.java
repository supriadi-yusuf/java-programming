package barokah.inc.belajar.jpa.listener;

import java.time.LocalDateTime;

public interface UpdatedAtAware {
    void setUpdatedAt(LocalDateTime dateTime);
}
