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


    @PostMapping(value = "/category/insert")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            System.out.println("---------------category passed----------"+categoryDTO.getName());
            Category category = categoryService.creatCategory(categoryDTO.getName(),categoryDTO.getImage(),categoryDTO.getDescription());

            return ResponseEntity.ok(category);
        } catch (CustomeException e) {

            System.out.println("---------------category non----------");

            e.getMessageError();
        }
    return null;
    }

    @GetMapping("category/{name}")
    public ResponseEntity<Optional<Category>> sendCategoryByName(@PathVariable(value = "name") String name){
        Optional<Category> category = categoryService.getCategoryByName(name);
        return ResponseEntity.ok(category);
    }

    @GetMapping("category/categorylist")
    public ResponseEntity<Iterable<Category>> listCategory(){
        Iterable<Category> categories = categoryService.CategoryList();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("category/delete/{id}")
    public void categoryDeleteById(@PathVariable(value = "id") Long id)throws CustomeException {

        try {
            System.out.println("hello wod");
            categoryService.deleteCategory(id);
        } catch (CustomeException e) {
            e.getMessageError();
        }

    }

}
