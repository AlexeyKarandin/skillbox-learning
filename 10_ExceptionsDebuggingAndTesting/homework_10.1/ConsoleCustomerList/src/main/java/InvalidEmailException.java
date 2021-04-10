public class InvalidEmailException extends IllegalArgumentException {

    private final String number;
    private String message;


    public InvalidEmailException(String illegalValueMessage, String number) {
        super();
        this.number = number;
        message = illegalValueMessage;
    }

    @Override
    public String getMessage() {
        message += " Введено: " + number;
        return message;
    }
}
