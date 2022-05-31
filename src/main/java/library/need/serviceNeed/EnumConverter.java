package library.need.serviceNeed;

import library.need.Sexe;
import org.springframework.core.convert.converter.Converter;

public class EnumConverter implements Converter<String, Sexe> {

    @Override
    public Sexe convert(String source) {
        try {
            return Sexe.valueOf(source.toLowerCase());
        }catch (IllegalArgumentException e){
           throw e;
        }
    }

}
