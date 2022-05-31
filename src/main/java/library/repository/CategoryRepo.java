package library.repository;

import library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepo extends CrudRepository<Category,Long> {


    //@Query("SELECT C FROM Category C WHERE C.name =:name")
    Optional<Category> findCategoryByName(String name);

    @Override
    void delete(Category category);

}
