package library.service;

import library.dto.UserDTO;
import library.exception.CustomeException;
import library.model.Role;
import library.model.Token;
import library.model.User;
import library.repository.RoleRepo;
import library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo ;

  //  private PasswordEncoderService encoderService;



    //generer un Token unique l'user
    public Token getToken(){
        UUID uuid = UUID.randomUUID();
        String valeur = uuid.toString();// recupere le token sous forme d'une chaine de caractere
        Calendar calendar = Calendar.getInstance(); // la date actuelle
        Date expirationDate = calendar.getTime(); // date d'expiration
        return new Token(valeur,expirationDate); // retour un Token
    }


    // creation d'un utilisateur;
    public User creatUser(UserDTO userDTO) throws CustomeException {

        HashMap<String,String> error = new HashMap<>();
        // verification email
        String regex = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*";

        // verification bdd
        Optional<User> userEmail = userRepo.findByEmail(userDTO.getEmail());
        Optional<Role> roleUser = roleRepo.findByNom(Role.USER);
        Optional<User> userPseudo = userRepo.findByPseudo(userDTO.getPseudo());

        if (userEmail.isPresent()) {
            error.put("Email exitant","User another email");
        }
        if (userPseudo.isPresent()) {
            error.put("Pseudo exitant","cree un autre pseudo");
        }
        if (!userDTO.getEmail().matches(regex)) {
            error.put("errEmail", "email incorrecte");
        }
        if (!userDTO.getPassWord().equals(userDTO.getPaasWord02())){
            error.put("mots de pas incorrect","Veuillier verifier le mots de passe");
        }else if(userDTO.getPassWord().length()<10){
            error.put("erreursMdp", "il faut au moins 10 caractères pour Mdp");
        }
        if (!error.isEmpty()) {
            CustomeException exception =new CustomeException("Echec inscriptiion",error);
            throw exception;
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstname(userDTO.getFirstname());
        user.setLastName(userDTO.getLastName());
        user.setSexe(userDTO.getSexe());
        user.setPhoto(userDTO.getPhoto());
        user.setDateBirth(userDTO.getDateBirth());
        user.setPseudo(userDTO.getPseudo());
        //psd encoder
        //String psd =encoderService.encoder(userDTO.getPassWord());
       // user.setPassWord(psd);
        userRepo.save(user);
        return user;
    }
}
