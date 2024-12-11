package jay.inventory_management_system.Category.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String description;

    @Column(updatable = false, insertable = false)
    private Date createdAt;

    @Column(updatable = false, insertable = false)
    private Date updatedAt;

    public Category() {
    }

    public Category(Long id, String categoryName, String description, Date createdAt, Date updatedAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Category(String categoryName, String description, Date createdAt, Date updatedAt) {
        this.categoryName = categoryName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
