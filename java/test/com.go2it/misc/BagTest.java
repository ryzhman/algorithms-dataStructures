package com.go2it.misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTest {

    @Test
    public void test() {
        Bag<String> bag = new Bag<>();
        bag.push("A");
        bag.push("B");
        bag.push("C");
        bag.push("D");

        List<String> result = new ArrayList<>();
        for (String a : bag) {
            result.add(a);
        }

        assertTrue(result.containsAll(Stream.of("A", "B", "C", "D").collect(Collectors.toList())));
    }
}
