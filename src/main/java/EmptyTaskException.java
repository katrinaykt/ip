public class EmptyTaskException extends RuntimeException{

    public EmptyTaskException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "EmptyTask: " + getMessage();
    }
}
