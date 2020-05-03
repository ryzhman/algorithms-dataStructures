package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeMadeLinkedListBasedStackTest {
    @Test
    public void testHappyPath() {
        final HomeMadeLinkedListBasedStack arrayBasedStackTest = new HomeMadeLinkedListBasedStack();
        arrayBasedStackTest.push("1");
        arrayBasedStackTest.push("2");
        arrayBasedStackTest.push("3");
        arrayBasedStackTest.push("4");
        arrayBasedStackTest.push("5");

        assertAll(() -> {
            assertEquals(5, arrayBasedStackTest.size());
            assertEquals("5", arrayBasedStackTest.pop());
            assertEquals(4, arrayBasedStackTest.size());

            assertEquals("4", arrayBasedStackTest.pop());
            assertEquals("3", arrayBasedStackTest.pop());
            assertEquals("2", arrayBasedStackTest.pop());
            assertEquals("1", arrayBasedStackTest.pop());
            assertEquals(0, arrayBasedStackTest.size());
            assertTrue(arrayBasedStackTest.isEmpty());
            assertNull(arrayBasedStackTest.pop());
        });
    }
}
