package library.controler.user;

import library.dto.IncriptionDTO;
import library.exception.CustomeException;
import library.model.Autor;
import library.service.user.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/autor")
@Controller
@CrossOrigin
public class AutorControler  {

    @Autowired
    private AutorService autorService;

    @PostMapping("/autor/insert")
    public ResponseEntity<Autor> autoRegistre(@RequestBody IncriptionDTO autoDTO){

        try {
            System.out.println("-------passeee-----------------");
            Autor autor = autorService.creatAutor(autoDTO);
            return ResponseEntity.ok(autor);
        } catch (CustomeException e) {
            e.fillInStackTrace();

            System.out.println("-------------capturer default-------------");

        }
     return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Autor>> receiveAllAutor(){
        List<Autor> autors = autorService.getAllAutor();
        return ResponseEntity.ok(autors);
    }

}
