public class DeadlineTaskException extends RuntimeException {

    public DeadlineTaskException(String e) {
        super(e);
    }

    @Override
    public String toString() {
        return "DeadlineTaskException: " + getMessage();
    }
}
