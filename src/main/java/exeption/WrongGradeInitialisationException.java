package exeption;

public class WrongGradeInitialisationException extends Exception {
    public WrongGradeInitialisationException() {
    }

    public WrongGradeInitialisationException(String message) {
        super(message);
    }

    public WrongGradeInitialisationException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongGradeInitialisationException(Throwable cause) {
        super(cause);
    }
}
