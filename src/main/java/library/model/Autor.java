package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Autor implements Serializable extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,length = 255)
    private String about;

    @Column(nullable = false,length = 255)
    private String nationality;

    @Column(nullable = false,name = "typeAutor")
    private String type;

    // jointure
    @OneToMany(mappedBy ="autor")
    private Collection<Book> books;

    public Autor() {
        books = new ArrayList<>();
    }

    public Autor(String about, String nationality, String type) {
        super();
        this.about = about;
        this.nationality = nationality;
        this.type = type;
    }
}
