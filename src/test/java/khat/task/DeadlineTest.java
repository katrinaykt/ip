package khat.task;

import khat.exception.DeadlineTaskException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    @Test
    public void constructor_setsFieldsCorrectly() {
        Deadline deadline = new Deadline("essay", false, "29-08-2025 2359");
        assertEquals("essay", deadline.description);
        assertEquals(false, deadline.isDone);
        assertEquals("29-08-2025 2359", deadline.by);
        assertEquals(true, deadline.hasTime());
        assertEquals(LocalDateTime.of(2025, 8, 29, 23, 59), deadline.dateTime);
    }

    @Test
    public void constructor_invalidDeadline_exceptionThrown() {
        try {
            Deadline deadline = new Deadline("essay", false, "29/08/2025");
        } catch (DeadlineTaskException e) {
            assertEquals("Invalid date/time format! Use dd-MM-yyyy or dd-MM-yyyy HHmm!", e.getMessage());
        }
    }

    @Test
    public void toSaveString_correctFormat() {
        Deadline deadline = new Deadline("essay", false, "29-08-2025 2359");
        assertEquals("D | 0 | essay | 29-08-2025 2359", deadline.toSaveString());
    }

    @Test
    public void toString_correctFormat() {
        Deadline deadline = new Deadline("essay", true, "29-08-2025 2359");
        assertEquals("[D][X] essay (by: 29 Aug 25 1159pm)", deadline.toString());
    }
}