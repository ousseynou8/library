package library;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

public class WebSecurityConfig extends WebSecurityConfiguration {


    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.cors().and().csrf().disable();
    }
}
