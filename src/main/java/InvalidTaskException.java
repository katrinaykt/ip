public class InvalidTaskException extends RuntimeException {

    public InvalidTaskException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "I don't understand :(, try adding todo/deadline/event before the task!";
    }
}
