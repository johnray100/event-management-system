package jay.inventory_management_system.Category.Repository;

import jay.inventory_management_system.Category.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
    Category findByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "SELECT COUNT(c.id) FROM Category c") // SELECT COUNT(*)
    long countCategoryById(); // SELECT COUNT(id)
}
