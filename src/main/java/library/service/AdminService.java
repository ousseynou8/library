package library.service;

import library.model.Token;
import library.model.User;
import library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

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
    public User creatUser(String firstname, String lasName, String sexe, String photo, String email, Date dateBirth, String name, String passWord, Date lastConnecte){
         Optional<User> userEmail = userRepo.findByEmail(email);
        if (userEmail.isPresent()) {
            error.put("Email exitant","User another email");
        }


        return null;
    }


}
