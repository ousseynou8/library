package library.repository;

import library.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Long> {

    @Query("SELECT r FROM Role r WHERE r.nom =:roleName")
    Optional<Role> findByNom(String roleName);
}
