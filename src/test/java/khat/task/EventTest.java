package khat.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    public void constructor_setsFieldsCorrectly() {
        Event event = new Event("meeting", false, "11am", "12pm");
        assertEquals("meeting", event.description);
        assertEquals(false, event.isDone);
        assertEquals("11am", event.from);
        assertEquals("12pm", event.to);
    }

    @Test
    public void toSaveString_correctFormat() {
        Event event = new Event("meeting", false, "11am", "12pm");
        assertEquals("E | 0 | meeting | 11am-12pm", event.toSaveString());
    }

    @Test
    public void toString_correctFormat() {
        Event event = new Event("meeting", true, "11am", "12pm");
        assertEquals("[E][X] meeting (from: 11am to: 12pm)", event.toString());
    }
}