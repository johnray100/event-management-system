package jay.inventory_management_system.Category.Controller;

import jay.inventory_management_system.Category.Model.Category;
import jay.inventory_management_system.Category.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // List
    @GetMapping("/category")
    public String list(Model model){
        model.addAttribute("activePage", "category");
        model.addAttribute("category", categoryService.getAllCategory());
        return "views/backend/category/index";
    }

    //Show Form
    @GetMapping(value = "/add-category")
    public String showForm(Model model, Category category){
        model.addAttribute("activePage", "category");
        model.addAttribute("category", category);
        return "views/backend/category/create";
    }

    // Save
    @PostMapping(value = "/create-category")
    public String createCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    // Delete
    @RequestMapping(value = "/delete-category/{id}")
    public String deleteCategoryById(@PathVariable(name = "id") long id, Model model){
        model.addAttribute("activePage", "category");
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }

    // Edit
    @GetMapping(value = "/edit-category/{id}")
    public String updateCategory(@PathVariable(value = "id")long id, Model model){
        Category category = categoryService.getCategoryById(id).get();
        model.addAttribute("activePage", "category");
        model.addAttribute("category", category);
        return "views/backend/category/update";
    }
}
