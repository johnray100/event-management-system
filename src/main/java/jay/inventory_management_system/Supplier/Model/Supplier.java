package jay.inventory_management_system.Supplier.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
@Getter
@Setter
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private String contact;
    private String address;
    private String email;

    public Supplier() {
    }

    public Supplier(Long id, String name, String contact, String address, String email) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
    }
}
