package library.model;

import library.need.Sexe;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String Firstname;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Sexe sexe;
    @Column(nullable = false,unique = true)
    private String photo;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;



    public Personne() {
     super();
    }

    public Personne(String firstname, String lastName, Sexe sexe, String photo, String email, Date dateBirth) {
        Firstname = firstname;
        this.lastName = lastName;
        this.sexe = sexe;
        this.photo = photo;
        this.email = email;
        this.dateBirth = dateBirth;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lasName) {
        this.lastName = lasName;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }
}
