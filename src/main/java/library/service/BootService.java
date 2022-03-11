package library.service;

import library.model.Book;
import library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BootService {

    @Autowired
    private BookRepo bookRepo;

    public Optional<Book> findeById(int id){
        Optional<Book> book = bookRepo.findBookBy(id);
        return book;
    }
}
