package com.go2it.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBasedStackTest {
    @Test
    public void testHappyPath() {
        final ArrBasedStackOfStrings arrayBasedStackTest = new ArrBasedStackOfStrings(5);
        arrayBasedStackTest.push("1");
        arrayBasedStackTest.push("2");
        arrayBasedStackTest.push("3");
        arrayBasedStackTest.push("4");
        arrayBasedStackTest.push("5");

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
    }


}
