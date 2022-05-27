package library.controler.book;

import library.dto.BookDTO.CategoryDTO;
import library.exception.CustomeException;
import library.model.Category;
import library.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class CategoryControler {

    @Autowired
    private CategoryService categoryService;




    @PostMapping("/category/insert")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            System.out.println("---------------category passed----------"+categoryDTO.getName());
            Category category = categoryService.creatCategory(categoryDTO.getName(),categoryDTO.getImage(),categoryDTO.getDescription());

            return ResponseEntity.ok(category);
        } catch (CustomeException e) {

            System.out.println("---------------category non----------");

            e.printStackTrace();
        }
    return null;
    }




    @GetMapping("/{name}")
    ResponseEntity<Optional<Category>> sendCategoryByName(@PathVariable(value = "name") String name){

        Optional<Category> category = categoryService.getCategoryByName(name);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/categorylist")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categories = categoryService.CategoryList();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/delete/{id}")
    public void categoryDeleteById(@PathVariable(value = "id") Long id) {
        try {
            categoryService.deleteCategoryById(id);
        } catch (CustomeException e) {
            e.printStackTrace();
        }

    }
}
