package khat.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    public void constructor_setsFieldsCorrectly() {
        Todo todo = new Todo("Read book", false);
        assertEquals("Read book", todo.description);
        assertEquals(false, todo.isDone);
    }

    @Test
    public void toSaveString_correctFormat() {
        Todo todo = new Todo("Read book", true);
        assertEquals("T | 1 | Read book", todo.toSaveString());
    }

    @Test
    public void toString_correctFormat() {
        Todo todo = new Todo("Read book", false);
        assertEquals("[T][ ] Read book", todo.toString());
    }
}