package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String Firstname;
    private String lastName;
    private String sexe;
    private String photo;
    private String email;
    private Date dateBirth;



    public Personne() {
     super();
    }
    public Personne(String firstname, String lastName, String sexe, String photo, String email, Date dateBirth) {
        this.Firstname = firstname;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
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
