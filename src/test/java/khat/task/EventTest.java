package khat.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void constructor_validInputs_setsFieldsCorrectly() {
        Event event = new Event("meeting", false, "11am", "12pm");
        assertEquals("meeting", event.description);
        assertFalse(event.isDone);
        assertEquals("11am", event.from);
        assertEquals("12pm", event.to);
    }

    @Test
    public void toSaveString_validEvent_returnsCorrectFormat() {
        Event event = new Event("meeting", false, "11am", "12pm");
        assertEquals("E | 0 | meeting | 11am-12pm", event.toSaveString());
    }

    @Test
    public void toString_doneEvent_returnsCorrectFormat() {
        Event event = new Event("meeting", true, "11am", "12pm");
        assertEquals("[E][X] meeting (from: 11am to: 12pm)", event.toString());
    }
}
