package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Role implements Serializable {
    @Id
    @Column( nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static final String USER ="ROLE_ADMIN";
    private static final String ADMIN ="ROLE_USER";

    @Column(length = 100,nullable = false)
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
