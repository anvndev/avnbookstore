package bookstore.avn.avnbookstore.controller;


import bookstore.avn.avnbookstore.entity.Category;
import bookstore.avn.avnbookstore.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> categories = categoryServices.getAllCategories();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/add";
        }
        categoryServices.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long categoryId, Model model) {
        Category category = categoryServices.getCategoryById(categoryId);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long categoryId,
                               @Valid @ModelAttribute("category") Category updatedCategory,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/edit";
        }

        Category category = categoryServices.getCategoryById(categoryId);
        category.setName(updatedCategory.getName());
        // Update other properties of the category if necessary

        categoryServices.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId) {
        categoryServices.deleteCategory(categoryId);
        return "redirect:/categories";
    }
}
