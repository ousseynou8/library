/**
 *
 */
package library.service.category;

import library.dto.BookDTO.TypeDTO;
import library.exception.CustomeException;
import library.model.Category;
import library.model.Type;
import library.repository.CategoryRepo;
import library.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;


@Service
public class CategoryService {

    private HashMap<String,String> ex = new HashMap<>();

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private TypeRepo typeRepo;


    public Category creatCategory(String name,String image,String description) throws CustomeException {
        Optional<Category> categoryName = categoryRepo.findCategoryByName(name);

        if(categoryName.isPresent()) {
            ex.put("error","err");
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
     *
     * @return
     */
    public Iterable<Category> CategoryList(){

       Iterable<Category> category = categoryRepo.findAll();
        return category;
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


    /**
     *
     * @param id
     * @throws CustomeException
     */
     public void deleteCategory(Long id) throws CustomeException {
         Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()) {
            Category category1 = category.get();
            categoryRepo.delete(category1);
        }
        ex.put("error insert","try againe");
        CustomeException customeException= new CustomeException("error",ex);
        throw customeException;
    }


}
