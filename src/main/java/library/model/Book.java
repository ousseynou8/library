package library.model;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "BookTile", nullable = false,length = 255)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(name ="BookSummary",nullable = false)
    private String summary;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false,unique = true)
    private String isbn;


    //JOINTURE
    @ManyToOne
    private Autor autor;
    @OneToMany
    private Collection<Loan> loans;
    @ManyToOne
    private Category category;

    public Book() {
        loans = new ArrayList<>();
    }

    public Book(String title, String description, String summary, int quantity, String isbn, Autor autor, Category category) {
        super();
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.quantity = quantity;
        this.isbn = isbn;
        this.autor = autor;
        this.category = category;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
