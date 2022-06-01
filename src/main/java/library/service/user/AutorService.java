package library.service.user;

import library.dto.IncriptionDTO;
import library.exception.CustomeException;
import library.model.Autor;
import library.model.Type;
import library.need.Sexe;
import library.need.serviceNeed.EnumConverter;
import library.repository.AutorRepo;
import library.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService extends EnumConverter{

    @Autowired
    private AutorRepo autorRepo;

    @Autowired
    private TypeRepo typeRepo;

    private HashMap<String,String> ex = new HashMap<>();

    //Regex
    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public Autor creatAutor(IncriptionDTO autorDTO) throws CustomeException {
        Optional<Autor> autor = autorRepo.findAutorByEmail(autorDTO.getEmail());
        Optional<Type>  typeAuto = typeRepo.findById(autorDTO.getType());

        if (autor.isPresent()) {
            ex.put("Error","Autor present in Data base");
        }
        Autor autor1 = new Autor();
        autor1.setFirstname(autorDTO.getFirstname());
        autor1.setLastName(autorDTO.getLastName());
        autor1.setAbout(autorDTO.getAbout());
        autor1.setNationality(autorDTO.getNationality());
        autor1.setDateBirth(autorDTO.getDateBirth());
        // calculer l'age -> a partire de la date de naissance
        autor1.setPhoto(autorDTO.getPhoto());


        if (typeAuto.isPresent()) {
            System.out.println("--------type ----------passer-------");
            Type type = typeAuto.get();
            type.setAutor(autor1);
        }

        if (autorDTO.getEmail().matches(regex)) {
            System.out.println("-----------autor---------email------passer---------");
            autor1.setEmail(autorDTO.getEmail());
        }/*else {
            ex.put("Error","Email not acceptable");
        }*/


        if (autorDTO.getSexe().equals(Sexe.Femme)) {
            System.out.println("-----------Femme sexe passee -----");
            Sexe sexe = convert(autorDTO.getSexe());
            autor1.setSexe(sexe.Femme);
        }else if (autorDTO.getSexe().equals(Sexe.Homme)) {
            System.out.println("-----------homme sexe passee -----");

            Sexe sexe = convert(autorDTO.getSexe());
            autor1.setSexe(sexe);
        }

        if (ex.isEmpty()) {
            autorRepo.save(autor1);
            return autor1;
        }else {
            CustomeException error = new CustomeException("Echec ",ex);
            throw error;
        }

    }

    public List<Autor> getAllAutor() {
        return autorRepo.findAll();
    }
}
