public class InvalidPhoneException extends IllegalArgumentException {
    private final String phone;
    private String message;

    public InvalidPhoneException(String message, String phone) {
        super();
        this.message = message;
        this.phone = phone;
    }

    @Override
    public String getMessage() {
        message += " Введено: " + phone;
        return message;
    }
}
