package library.repository;

import library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Long> {

    @Query("select b from Book b where b.id =:id")
    public Optional<Book> findBookBy(int id);


}
