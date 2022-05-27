package library.service.category;

import library.dto.BookDTO.CategoryDTO;
import library.exception.CustomeException;
import library.model.Category;
import library.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private HashMap<String,String> ex = new HashMap<>();

    @Autowired
    private CategoryRepo categoryRepo;




    public Category creatCategory(String name,String image,String description) throws CustomeException {
        Optional<Category> categoryName = categoryRepo.findCategoryByName(name);

        if (categoryName.isPresent()) {
            ex.put("error","erer");
            CustomeException customeException = new CustomeException("erreur",ex);
            return null;
        }
            Category category = new Category();
            category.setName(name);
            category.setDescription(description);
            category.setImage(image);
            categoryRepo.save(category);
            return category;

    }

    /**
     * list of book
     * @return
     */
    public List<Category> CategoryList(){
        return (List<Category>) categoryRepo.findAll();
    }

    /**
     * seach category by name
     * @param CategoryName
     * @return
     */
    public Optional<Category> getCategoryByName(String CategoryName){
        Optional<Category> category = categoryRepo.findCategoryByName(CategoryName);
        return category;
    }


     public void deleteCategoryById (Long id) throws CustomeException {
         Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            Category category1 = category.get();
            categoryRepo.delete(category1);
        }
        ex.put("erreur insert","try againe");
        CustomeException customeException= new CustomeException("erreur",ex);
        throw customeException;
    }
}
