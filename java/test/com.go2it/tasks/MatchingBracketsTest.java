package com.go2it.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchingBracketsTest {
    private final String VALID_SEQUENCE = "{([{}])}";
    private final String INVALID_SEQUENCE = "{([{}]}";
    @Test
    public void areAllBracketsClosedSuccess() {
        MatchingBrackets matchingBrackets = new MatchingBrackets();
        assertTrue(matchingBrackets.areAllBracketsClosed(VALID_SEQUENCE));
    }

    @Test
    public void areAllBracketsClosedFailed() {
        MatchingBrackets matchingBrackets = new MatchingBrackets();
        assertFalse(matchingBrackets.areAllBracketsClosed(INVALID_SEQUENCE));
    }

    @Test
    public void findMissingBracketFailed() {
        MatchingBrackets matchingBrackets = new MatchingBrackets();
        assertEquals(')', matchingBrackets.findMissingBracket(INVALID_SEQUENCE));
    }


    @Test
    public void findMissingBracketSuccess() {
        MatchingBrackets matchingBrackets = new MatchingBrackets();
        assertEquals(' ', matchingBrackets.findMissingBracket(VALID_SEQUENCE));
    }

}
