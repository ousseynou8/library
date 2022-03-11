package library.repository;

import library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public interface UserRepo extends JpaRepository<User,Long> {

    @Query("SELECT u from User u where u.email =:emailUser")
    public Optional<User> findByEmail(String emailUser);
}
