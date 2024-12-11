package jay.inventory_management_system.Supplier.Controller;

import jay.inventory_management_system.Supplier.Model.Supplier;
import jay.inventory_management_system.Supplier.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // List all suppliers
    @GetMapping("/suppliers")
    public String listSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("activePage", "suppliers");
        return "views/backend/supplier/index";
    }

    // Show create supplier form
    @GetMapping("/add-supplier")
    public String showSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        model.addAttribute("activePage", "suppliers");
        return "views/backend/supplier/create";
    }

    // Save supplier (create or update)
    @PostMapping({"/create-supplier", "/update-supplier/{id}"})
    public String saveSupplier(Model model, Supplier supplier) {
        model.addAttribute("activePage", "suppliers");
        supplierService.createSupplier(supplier);
        return "redirect:/suppliers";
    }

    // Show update supplier form
    @GetMapping("/update-supplier/{id}")
    public String showEditSupplierForm(@PathVariable Long id, Model model) {
        Supplier supplier = supplierService.getSupplierById(id);
        model.addAttribute("supplier", supplier);
        model.addAttribute("activePage", "suppliers");
        return "views/backend/supplier/update";
    }

    // Delete supplier
    @GetMapping("/delete-supplier/{id}")
    public String deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }
}

