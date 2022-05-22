package library.controler.user;

import library.dto.UserDTO;
import library.exception.CustomeException;
import library.model.User;
import library.service.AdminService;
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
    public ResponseEntity<User> userRegistre(@RequestBody UserDTO userDTO) throws CustomeException {
        System.out.println("ddddddzdsdsdvdsvdsvdsvds"+userDTO.getPaasWord02());
        System.out.println("ddddddzdsdsdvdsvdsvdsvds"+userDTO.getEmail());
        User user = adminService.creatUser(userDTO);
        return ResponseEntity.ok(user);
    }

}
