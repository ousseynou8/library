package library.service.book;

import library.dto.BookDTO.TypeDTO;
import library.model.Type;
import library.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepo typeRepo;

    private HashMap<String,String> ex = new HashMap<>();


    public Type CreatType(TypeDTO typeDTO){
        Optional<Type> typeName = typeRepo.findByTypeName(typeDTO.getName());
        if (typeName.isPresent()) {
            ex.put("error","Type existant");
        }
        Type type = new Type();
        type.setType(typeDTO.getName());
        type.setDescription(typeDTO.getDescription());
        typeRepo.save(type);
        return null;
    }
}
