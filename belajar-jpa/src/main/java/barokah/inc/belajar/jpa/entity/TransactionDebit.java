package barokah.inc.belajar.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions_debit")
@Data
@NoArgsConstructor
public class TransactionDebit extends Transaction{
    @Column(name = "debit_amount")
    private Long debitAmount;
}
