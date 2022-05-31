package library.repository;

import library.model.Autor;
import library.model.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeRepo extends CrudRepository<Type,Long> {

    @Override
    Optional<Type> findById(Long aLong);


    Optional<Type> findByAutor(Autor autor);

    @Override
    void deleteById(Long aLong);
}
