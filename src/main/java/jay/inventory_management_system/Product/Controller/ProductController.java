package jay.inventory_management_system.Product.Controller;

import jay.inventory_management_system.Category.Service.CategoryService;
import jay.inventory_management_system.Product.Model.Product;
import jay.inventory_management_system.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // List all products
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts()); // Use productList consistently
        model.addAttribute("activePage", "products"); // Add activePage attribute
        return "views/backend/product/index"; // Render the product list view
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam(required = false) String keyword, Model model) {
        List<Product> products;

        // Check if keyword is empty or null
        if (keyword == null || keyword.trim().isEmpty()) {
            products = productService.getAllProducts(); // Return all products if no keyword
        } else {
            products = productService.searchProductsByName(keyword.trim());
        }

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword); // Retain keyword in the search box
        model.addAttribute("activePage", "products");

        return "views/backend/product/index"; // Render the product list view
    }


    // Show product form for adding or editing a product
    @GetMapping("/add-product")
    public String showProductForm(@RequestParam(required = false) Long id, Model model) {
        Product product;
        if (id != null) {
            product = productService.getProductById(id).get(); // Retrieve product by ID
        } else {
            // Create a new Product object for adding
            product = new Product();
        }
        // Add attributes to the model
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategory()); // Retrieve all categories
        model.addAttribute("activePage", "products"); // Highlight the active menu item

        return "views/backend/product/create"; // Render the product form view
    }


    // Save or update a product
    @PostMapping("/create-product")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("activePage", "products");
        if (product.getId() == null) {
            productService.createProduct(product); // Add new product
        } else {
            productService.updateProduct(product.getId(), product); // Update existing product
        }
        return "redirect:/products"; // Redirect to product list
    }

    // Delete a product by ID
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products"; // Redirect to product list
    }
}
