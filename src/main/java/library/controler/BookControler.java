package library.controler;

import library.model.Book;
import library.service.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@CrossOrigin("*")
public class BookControler {

    @Autowired
    private BootService bootService;

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") int id){
        Optional<Book> books = bootService.findeById(id);
        return ResponseEntity.ok(books);
    }
}
