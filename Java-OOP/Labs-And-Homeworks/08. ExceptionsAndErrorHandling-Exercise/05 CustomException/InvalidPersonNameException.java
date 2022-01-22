package CustomException_5;

public class InvalidPersonNameException extends RuntimeException{
    private String message;

    protected InvalidPersonNameException(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
