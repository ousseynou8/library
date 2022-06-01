package library.repository;

import library.model.Autor;
import library.model.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeRepo extends CrudRepository<Type,Long> {

    @Query("SELECT T from Type T where T.id=:idType")
    Optional<Type> findById(long idType);

    @Query("SELECT T FROM Type T WHERE T.type=:typeName")
    Optional<Type> findByTypeName(String typeName);

}
