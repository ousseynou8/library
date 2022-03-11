package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class User extends Personne implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column(length = 255,nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String passWord;
    @Column(nullable = false)
    private String type;
    @Column(nullable = true)
    private Date lastConnecte;

    //JOINTURE
    @OneToMany(mappedBy = "user")
    private Collection<Loan> loans;

    public User() {
        loans = new ArrayList<>();
    }

    public User(String firstname, String lasName, String sexe, String photo, String email, Date dateBirth, long id, String name, String passWord, String type, Date lastConnecte) {
        super(firstname, lasName, sexe, photo, email, dateBirth);
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.type = type;
        this.lastConnecte = lastConnecte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastConnecte() {
        return lastConnecte;
    }

    public void setLastConnecte(Date lastConnecte) {
        this.lastConnecte = lastConnecte;
    }

    public Collection<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Collection<Loan> loans) {
        this.loans = loans;
    }
}
