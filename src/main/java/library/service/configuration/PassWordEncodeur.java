package library.service.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PassWordEncodeur {

    private BCryptPasswordEncoder passwordEncoder;

    public PassWordEncodeur() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encoder(String rawPassWord){
       return passwordEncoder.encode(rawPassWord);
    }

    public Boolean match(String rawPassword,String encodePassWord){
        return passwordEncoder.matches(rawPassword,encodePassWord);
    }
}
