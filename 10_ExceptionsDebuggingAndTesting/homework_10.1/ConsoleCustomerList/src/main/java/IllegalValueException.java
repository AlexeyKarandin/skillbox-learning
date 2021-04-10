public class IllegalValueException extends Exception {

    private String number;


    public String getNumber() {
        return number;
    }

    public IllegalValueException(String illegalValueMessage, String number) {
        super(illegalValueMessage);
        this.number = number;
    }
}
