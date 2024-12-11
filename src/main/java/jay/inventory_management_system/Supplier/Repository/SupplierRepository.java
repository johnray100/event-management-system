package jay.inventory_management_system.Supplier.Repository;

import jay.inventory_management_system.Supplier.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT COUNT(s.id) FROM Supplier s")
    long countSupplierById();
}
