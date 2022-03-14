package library.service;

import library.exception.CustomeException;
import library.model.Token;
import library.model.User;
import library.repository.UserRepo;
import library.service.configuration.PassWordEncodeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    private PassWordEncodeur passWordEncodeur;

    private HashMap<String,String> error;

    //generer un Token unique l'user
    public Token getToken(){
        UUID uuid = UUID.randomUUID();
        String valeur = uuid.toString();// recupere le token sous forme d'une chaine de caractere
        Calendar calendar = Calendar.getInstance(); // la date actuelle
        Date expirationDate = calendar.getTime(); // date d'expiration
        return new Token(valeur,expirationDate); // retour un Token
    }


    // creation d'un utilisateur;
    public User creatUser(String firstname, String lastName, String sexe, String photo, String email, Date dateBirth, String pseudo
            , String passWord){
         Optional<User> userEmail = userRepo.findByEmail(email);
        if (userEmail.isPresent()) {
            error.put("Email exitant","User another email");
        }
        User user = new User();
        user.setFirstname(firstname);
        user.setLasName(lastName);
        user.setSexe(sexe);
        user.setPhoto(photo);
        user.setEmail(email);
        user.setDateBirth(dateBirth);
        user.setPseudo(pseudo);

        user.setPassWord( passWordEncodeur.encoder(passWord));// encode passsWord
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        if (!error.isEmpty()) {
            CustomeException exception =new CustomeException();
            exception.setMessageError(error);
        }else {
            userRepo.save(user);
            return user;
        }

        return null;
    }


}
