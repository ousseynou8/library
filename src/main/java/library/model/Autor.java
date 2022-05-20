package library.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
public class Autor extends Personne{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 255)
    private String about;

    @Column(nullable = false,length = 255)
    private String nationality;

    @Column(nullable = false)
    private String type;

    // jointure
    @OneToMany(mappedBy ="autor")
    private Collection<Book> books;

    @ManyToOne
    private Token token;

    public Autor() {
        books =new ArrayList<>();
    }

    public Autor(long id, String about, String nationality, String type, Collection<Book> books, Token token) {
        super();
        this.id = id;
        this.about = about;
        this.nationality = nationality;
        this.type = type;
        this.books = books;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
