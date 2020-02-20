package exeption;

public class EmptyStudentLearningCoursesException extends Exception {
    public EmptyStudentLearningCoursesException() {
    }

    public EmptyStudentLearningCoursesException(String message) {
        super(message);
    }

    public EmptyStudentLearningCoursesException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStudentLearningCoursesException(Throwable cause) {
        super(cause);
    }
}
