package library.model;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class Personne implements Serializable {

    private long id;
    private String Firstname;
    private String lasName;
    private String sexe;
    private String photo;
    private String email;
    private Date dateBirth;

    public Personne() {
     super();
    }
    public Personne(String firstname, String lasName, String sexe, String photo, String email, Date dateBirth) {
        this.Firstname = firstname;
        this.lasName = lasName;
        this.sexe = sexe;
        this.photo = photo;
        this.email = email;
        this.dateBirth = dateBirth;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
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
