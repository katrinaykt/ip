public class EventTaskException extends RuntimeException{

    public EventTaskException(String e) {
        super(e);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
