package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column( nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private  String value;

    @Column(nullable = false)
    private Date dateExpiration;

    @OneToMany(mappedBy = "token")
    private Collection<Autor> autors;

    @OneToMany(mappedBy = "token")
    private Collection<User> users;

    public Token() {
        autors = new ArrayList<>();
        users = new ArrayList<>();
    }

    public Token(String value, Date dateExpiration) {
        this.value = value;
        this.dateExpiration = dateExpiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Collection<Autor> getAutors() {
        return autors;
    }

    public void setAutors(Collection<Autor> autors) {
        this.autors = autors;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
