package library.dto;


import library.model.Personne;

import java.util.Date;

public class UserDTO extends Personne {
    private String pseudo;
    private String passWord;
    private String paasWord02;

    public UserDTO(String firstname, String lastName, String sexe, String photo, String email, Date dateBirth, String pseudo, String passWord, String paasWord02) {
        super(firstname, lastName, sexe, photo, email, dateBirth);
        this.pseudo = pseudo;
        this.passWord = passWord;
        this.paasWord02 = paasWord02;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPaasWord02() {
        return paasWord02;
    }

    public void setPaasWord02(String paasWord02) {
        this.paasWord02 = paasWord02;
    }


    public String getPseudo() {
        return pseudo;
    }

    public String getPassWord() {
        return passWord;
    }
}
