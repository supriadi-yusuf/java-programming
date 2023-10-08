package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments_gopay")
@Data
@NoArgsConstructor
public class PaymentGopay extends Payment {
    @Column(name = "gopay_id")
    private String gopayId;
}
