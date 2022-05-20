package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;


    public static final String USER = "ROLE_ADMIN";
    public static final String ADMIN ="ROLE_USER" ;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    //JOINTURE
    @OneToMany(mappedBy = "role")
    private Collection<User> users;

    public Role() {
        users = new ArrayList<>();
    }

    public Role(String nom) {
        this.nom = nom;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
