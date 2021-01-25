package com.go2it.tasks;

import java.util.HashMap;
import java.util.Map;

public class MatchingBrackets {
    private class Stack {
        private char[] stack;
        private int currentSize = 0;

        public Stack() {
            this.stack = new char[10];
        }

        public void push(char c) {
            stack[currentSize++] = c;
        }

        public char pop() {
            char c = stack[--currentSize];
            stack[currentSize] = '0';
            return c;
        }
    }

    public boolean areAllBracketsClosed(String sequence) {
        char[] chars = sequence.toCharArray();
        Stack stack = new Stack();
        Map<Character, Character> bracketsMap = prepareBracketsMap();
        for (int i = 0; i < chars.length; i++) {
            char currentBracket = chars[i];
            //opening bracket
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else {
                //closing bracket
                char lastStackedBracket = stack.pop();
                //if the brackets don't match, fail
                if (bracketsMap.get(lastStackedBracket) != currentBracket) {
                    return false;
                }
            }
        }
        return true;
    }

    public char findMissingBracket(String sequence) {
        char[] chars = sequence.toCharArray();
        Stack stack = new Stack();
        Map<Character, Character> bracketsMap = prepareBracketsMap();
        for (int i = 0; i < chars.length; i++) {
            char currentBracket = chars[i];
            //opening bracket
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else {
                //closing bracket
                char lastStackedBracket = stack.pop();
                //if the brackets don't match, fail
                if (bracketsMap.get(lastStackedBracket) != currentBracket) {
                    return bracketsMap.get(lastStackedBracket);
                }
            }
        }
        return ' ';
    }

    private Map<Character, Character> prepareBracketsMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        return map;

    }


}
