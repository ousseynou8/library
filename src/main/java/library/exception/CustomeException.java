package library.exception;

import java.util.HashMap;

public class CustomeException extends Exception{

    private HashMap<String,String> messageError;

    public CustomeException() {
        messageError =new HashMap<>();
    }

    public CustomeException(HashMap<String, String> messageError) {
        this.messageError = messageError;
    }

    public CustomeException(String message, HashMap<String, String> messageError) {
        super(message);
        this.messageError = messageError;
    }


    public HashMap<String, String> getMessageError() {
        return messageError;
    }

    public void setMessageError(HashMap<String, String> messageError) {
        this.messageError = messageError;
    }
}
