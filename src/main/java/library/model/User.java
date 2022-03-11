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
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date lastConnecte;

    //JOINTURE
    @OneToMany(mappedBy = "user")
    private Collection<Loan> loans;
    @ManyToOne
    private Role role;

    @ManyToOne
    private Token token;


    public User() {
        loans = new ArrayList<>();
    }

    public User(String firstname, String lasName, String sexe, String photo, String email, Date dateBirth, String name, String passWord, Date lastConnecte, Role role, Token token) {
        super(firstname, lasName, sexe, photo, email, dateBirth);
        this.name = name;
        this.passWord = passWord;
        this.lastConnecte = lastConnecte;
        this.role = role;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
