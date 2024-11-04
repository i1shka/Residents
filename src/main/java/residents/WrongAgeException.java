package residents;

public class WrongAgeException extends Exception {
    int age;

    public WrongAgeException(int age, String message) {
        super(message);
        this.age=age;
    }
}
