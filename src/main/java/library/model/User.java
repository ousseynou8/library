package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class User implements Serializable extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 255,nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String passWord;
    @Column(nullable = false,name = "userType")
    private String type;
    @Column(name = "lasteConnection")
    private Date lastConnecte;

    //JOINTURE
    @OneToMany(mappedBy = "user")
    private Collection<Loan> loans;

    public User() {
        loans = new ArrayList<>();
    }

    public User(String name, String passWord, String type, Date lastConnecte) {
        super();
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
