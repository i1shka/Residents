package residents;

public class WrongSexException extends Exception {
    int sex;

    public WrongSexException(int sex, String message) {
        super(message);
        this.sex=sex;
    }
}
