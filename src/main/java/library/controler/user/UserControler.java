package library.controler.user;

import library.dto.ConnectionDTO;
import library.exception.CustomeException;
import library.model.User;
import library.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
public class UserControler {

    @Autowired
    private AdminService adminService;

    @PostMapping("/user/registre")
    @ResponseBody
    public ResponseEntity<User> userRegistre(@RequestBody ConnectionDTO userDTO) throws CustomeException {

        User user = adminService.creatUser(userDTO);
        return ResponseEntity.ok(user);
    }

}
