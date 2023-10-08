package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions_credit")
@Data
@NoArgsConstructor
public class TransactionCredit extends Transaction{
    @Column(name = "credit_amount")
    private Long creditAmount;
}
