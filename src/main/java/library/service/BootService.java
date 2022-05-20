package library.service;

import library.exception.CustomeException;
import library.model.Autor;
import library.model.Book;
import library.model.Category;
import library.repository.AutorRepo;
import library.repository.BookRepo;
import library.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BootService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private AutorRepo autorRepo;

    HashMap<String,String> ex = new HashMap<>();

    //genrer un un isbn = un identifiant uniqe comme un token
    public String isbn(){
        UUID uuid=UUID.randomUUID();
        String isbn =uuid.toString();
        return isbn;
    }

    /**
     * retourner la liste des livre
     * @return boot
     */
    public List<Book> getAllBook(){
       List<Book> book = bookRepo.findAll();
       return book;
    }



    /**
     * @param title
     * @param description
     * @param summary
     * @param quantity
     * @param nbrPage
     * @return
     */
    public Book creatBoot(String title,String description,String summary,int quantity,int nbrPage,String isbn,String category,String image,Long autorId) throws CustomeException {
        Optional<Book> bookIsb = bookRepo.findBookByIsbnAnd(isbn);
        Optional<Category> categoryName= categoryRepo.findCategoryByName(category);
        Optional<Autor> autor = autorRepo.findById(autorId);

        if (!bookIsb.isPresent() && (!autor.isPresent()) && (!categoryName.isPresent())) {
           ex.put("Book exist","The book your trying to insert exist please try again");
        }else {
            Book book = new Book();
            book.setIsbn(isbn);
            book.setImage(image);
            book.setDescription(description);
            book.setQuantity(quantity);
            book.setSummary(summary);
            book.setTitle(title);
            book.setNbrPage(nbrPage);

            // autor
            Autor autorThisBook=autor.get();
            book.setAutor(autorThisBook);

            //
            if (categoryName.isPresent()) {
                Category category1= categoryName.get();
                book.setCategory(category1);
            }else {
                ex.put("Category inexistant","the category is not existant");
            }

            if (!ex.isEmpty()) {
                CustomeException customeException =new CustomeException("insection echec",ex);
                throw customeException;
            }

            bookRepo.save(book);
            return book;

        }
        return null;
    }

    /**
     *  autor Bismark
     * @param name
     * @param image
     * @param description
     * @return
     * @throws CustomeException
     */
    public Category creatCategory(String name,String image,String description) throws CustomeException {
        Optional<Category> categoryName = categoryRepo.findCategoryByName(name);
        if (categoryName.isPresent()) {
            ex.put("Already present","can't add this category already present");
            CustomeException customeException = new CustomeException("erreur",ex);
            throw  customeException;
        }else {
            Category category = categoryName.get();
            category.setName(name);
            category.setDescription(description);
            category.setImage(image);
            categoryRepo.save(category);
            return category;
        }

    }
}
