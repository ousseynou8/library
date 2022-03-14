package library.controler;

import library.model.User;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin("*")
public class UserControler {


    @PostMapping("/user/registre")
    public ResponseEntity<User> userRegistre( ){

        return null;
    }
}
