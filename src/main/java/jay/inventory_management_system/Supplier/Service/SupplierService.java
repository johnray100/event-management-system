package jay.inventory_management_system.Supplier.Service;

import jay.inventory_management_system.Supplier.Model.Supplier;
import jay.inventory_management_system.Supplier.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Get all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Get supplier by ID
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
    }

    // Create a new supplier
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Update an existing supplier
    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier existingSupplier = getSupplierById(id);

        existingSupplier.setName(updatedSupplier.getName());
        existingSupplier.setContact(updatedSupplier.getContact());
        existingSupplier.setAddress(updatedSupplier.getAddress());
        existingSupplier.setEmail(updatedSupplier.getEmail());

        return supplierRepository.save(existingSupplier);
    }

    // Delete a supplier by ID
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
