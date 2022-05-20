package library.exception;

import java.util.HashMap;

public class CustomeException extends Exception{

    private HashMap<String,String> messageError;



    public CustomeException(String echec_inscriptiion, HashMap<String, String> messageError) {
        this.messageError = messageError;
    }

    public CustomeException(String message, Throwable cause, HashMap<String, String> messageError) {
        super(message, cause);
        this.messageError = messageError;
    }

    public HashMap<String, String> getMessageError() {
        return messageError;
    }

    public void setMessageError(HashMap<String, String> messageError) {
        this.messageError = messageError;
    }
}
