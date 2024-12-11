package jay.inventory_management_system.Product.Repository;

import jay.inventory_management_system.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId); // Find products by category

    List<Product> findByProductNameContaining(String keyword); // Search by name

    @Query("SELECT COUNT(p.id) FROM Product p")
    long countProductById();
}

