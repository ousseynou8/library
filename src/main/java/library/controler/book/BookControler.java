package library.controler.book;

import library.dto.BookDTO.BootDTO;
import library.exception.CustomeException;
import library.model.Book;
import library.service.book.BootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController("/book")
@CrossOrigin("*")
public class BookControler {

    @Autowired
    private BootService bootService;


    @GetMapping("/book/{id}")
  public String test(){
        return "hello";
    }

    // @PathVariable is extracting values from the URI path,
    // it’s not encoded.
    // @RequestParam is encoded.

    @GetMapping("/book/all")
    public ResponseEntity<List<Book>> receiveBookList(){
        List<Book> books = bootService.getAllBook();
        return ResponseEntity.ok(books);
    }
    @GetMapping("/book/{name}")
    public ResponseEntity<Optional<Book>> receiveBookByName(@PathVariable("name")String name){
        Optional<Book> book= bootService.getBookByName(name);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/book/insert")
    public ResponseEntity<Book> addBook(@RequestBody BootDTO bootDTO ) throws CustomeException {

        try {

            Book book = bootService.creatBoot(bootDTO.getTitle(),bootDTO.getDescription(),bootDTO.getSummary(),bootDTO.getQuantity(),bootDTO.getNbrPage(),bootDTO.getIsbn(),bootDTO.getCategory(),bootDTO.getImage(),bootDTO.getAutorId());
            return ResponseEntity.badRequest().body(book);
        }catch (CustomeException exception){
            exception.getMessageError();
        }
        return null;
    }


}
