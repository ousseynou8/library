package library.controler.book;

import library.dto.BookDTO.TypeDTO;
import library.model.Type;
import library.service.book.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/type")
@Controller
@CrossOrigin("*")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/insert")
    ResponseEntity<Type> receiveType(@RequestBody TypeDTO typeDTO){

            Type type = typeService.CreatType(typeDTO);
            return ResponseEntity.ok(type);
    }
}
