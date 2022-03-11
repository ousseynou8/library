package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Autor extends Personne implements Serializable  {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
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
        books = new ArrayList<>();
    }

    public Autor(String firstname, String lasName, String sexe, String photo, String email, Date dateBirth, String about, String nationality, String type,Token token) {
        super(firstname, lasName, sexe, photo, email, dateBirth);
        this.about = about;
        this.nationality = nationality;
        this.type = type;
        this.token= token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
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
}
