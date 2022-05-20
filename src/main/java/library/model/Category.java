package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private String description;

    //JOINTURE
    @OneToMany(mappedBy = "category")
    private Collection<Book> books;

    public Category() {
        books = new ArrayList<>();
    }

    public Category(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
