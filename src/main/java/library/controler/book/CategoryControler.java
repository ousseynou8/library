package library.controler.book;

import library.dto.BookDTO.CategoryDTO;
import library.exception.CustomeException;
import library.model.Category;
import library.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController("/category")
@CrossOrigin("*")
public class CategoryControler {

    @Autowired
    private BootService bootService;

    @PostMapping("/insert")
    public ResponseEntity<Category> creatCategory(@RequestBody CategoryDTO categoryDTO) {
        System.out.println("sdqdqdddddddddddddddd --------------------    "+categoryDTO);
        try {
            Category category = bootService.creatCategory(categoryDTO);
            return ResponseEntity.ok(category);
        } catch (CustomeException e) {
            e.printStackTrace();
        }
    return null;
    }
}
