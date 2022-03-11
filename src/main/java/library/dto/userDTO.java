package library.dto;


import library.model.Personne;

import java.util.Date;

public class userDTO extends Personne {
    private String name;
    private String passWord;
    private Date lastConnecte;

    public userDTO(String firstname, String lasName, String sexe, String photo, String email, Date dateBirth, String name, String passWord, Date lastConnecte) {
        super(firstname, lasName, sexe, photo, email, dateBirth);
        this.name = name;
        this.passWord = passWord;
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

    public Date getLastConnecte() {
        return lastConnecte;
    }

    public void setLastConnecte(Date lastConnecte) {
        this.lastConnecte = lastConnecte;
    }
}
