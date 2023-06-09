package bookstore.avn.avnbookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bookstore.avn.avnbookstore.entity.Category;
import bookstore.avn.avnbookstore.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void addCategory(Category category) {
    }
}
