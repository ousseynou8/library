package library.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TypeAutor")
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,name = "typeAutor",unique = true)
    private String type;
    @Column(nullable = false)
    private String description;

    //Jointure
    @ManyToOne()
    private Autor autor;

    public Type(String type, String description, Autor autor) {
        this.type = type;
        this.description = description;
        this.autor = autor;
    }

    public Type() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
