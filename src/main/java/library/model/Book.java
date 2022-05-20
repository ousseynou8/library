package library.model;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column( nullable = false,length = 255)
    private String title;
    @Column( nullable = false,length = 255,unique = true)
    private String name;
    @Column(nullable = false,unique = true)
    private String description;
    @Column(nullable = false)
    private String summary;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false,unique = true)
    private String isbn;
    @Column(nullable = false)
    private int nbrPage;
    @Column(nullable = false,unique = true)
    private String image;

    //JOINTURE ;
    @ManyToOne
    private Autor autor;
    @OneToMany(mappedBy = "book")
    private Collection<Loan> loans;
    @ManyToOne
    private Category category;

    public Book() {
        loans = new ArrayList<>();
    }

    public Book(String title, String description, String summary, int quantity, String isbn, int nbrPage, String image, Autor autor, Category category,String name) {
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.quantity = quantity;
        this.isbn = isbn;
        this.nbrPage = nbrPage;
        this.image = image;
        this.autor = autor;
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Collection<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Collection<Loan> loans) {
        this.loans = loans;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
