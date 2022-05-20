package library.repository;

import library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Query("SELECT C FROM Category C WHERE c.name=:name")
    Optional<Category> findCategoryByName(String name);


}
