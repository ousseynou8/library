package library.repository;

import library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Long> {

    @Query("select b from Book b where b.id =:id")
    public Optional<Book> findBookBy(long id);

    @Query("select b from Book b WHERE b.isbn=:isbn")
    Optional<Book> findBookByIsbnAnd(String isbn);

    @Query("select b FROM Book b where b.name=:name")
    Optional<Book> findBookByName(String name);
}
