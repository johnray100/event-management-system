package jay.inventory_management_system;

import jay.inventory_management_system.Category.Repository.CategoryRepository;
import jay.inventory_management_system.Product.Repository.ProductRepository;
import jay.inventory_management_system.Supplier.Repository.SupplierRepository;
import jay.inventory_management_system.Transaction.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;


    @GetMapping("/")
    public String getDashboard(Model model) {
        model.addAttribute("activePage", "dashboard");
        model.addAttribute("category", categoryRepository.countCategoryById()); // get the count of category
        model.addAttribute("transaction", transactionRepository.countTransactionById());
        model.addAttribute("product", productRepository.countProductById());
        model.addAttribute("supplier", supplierRepository.countSupplierById());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "views/backend/dashboard/index";
    }
}
