package library.model;

import library.need.Sexe;

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

    // jointure
    @OneToMany(mappedBy ="autor")
    private Collection<Book> books;
    @ManyToOne
    private Token token;
    @OneToMany(mappedBy = "autor")
    private Collection<Type> types;

    public Autor() {
        books =new ArrayList<>();
        types = new ArrayList<>();
    }

    public Autor(String about, String nationality, Token token, Collection<Type> types) {
        this.about = about;
        this.nationality = nationality;
        this.token = token;
        this.types = types;
    }

    public Autor(String firstname, String lastName, Sexe sexe, String photo, String email, Date dateBirth, String about, String nationality, Token token, Collection<Type> types) {
        super(firstname, lastName, sexe, photo, email, dateBirth);
        this.about = about;
        this.nationality = nationality;
        this.token = token;
        this.types = types;
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

    public Collection<Type> getTypes() {
        return types;
    }

    public void setTypes(Collection<Type> types) {
        this.types = types;
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
