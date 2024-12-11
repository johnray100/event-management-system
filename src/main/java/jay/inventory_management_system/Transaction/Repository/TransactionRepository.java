package jay.inventory_management_system.Transaction.Repository;

import jay.inventory_management_system.Transaction.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Count id
    @Query(value = "SELECT COUNT(t.id)FROM Transaction t")
    Long countTransactionById();
}
