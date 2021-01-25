package com.go2it.dynamicConnectovity;

import com.go2it.dynamicConnectivity.DataStructure;
import com.go2it.dynamicConnectivity.QuickUnion;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnionQuickFindTest {
    @Test
    public static void main(String[] args) throws IOException {
        final DataStructure dataStructure;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("QuickUnionTest.txt"))) {
            dataStructure = initQuickFindTree(bufferedReader);
        }

        final List<Integer> component = dataStructure.findComponent(1, 5);
        assertEquals(Stream.of(1,3,8,9).collect(Collectors.toList()), component);
    }

    private static DataStructure initQuickFindTree(BufferedReader bufferedReader) throws IOException {
        int numberOfElems = Integer.parseInt(bufferedReader.readLine());
//        UnionQuickFind unionFind = new UnionQuickFind(numberOfElems);
        QuickUnion unionFind = new QuickUnion(numberOfElems);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] nodes = line.split(" ");
            final Integer i1 = Integer.valueOf(nodes[0]);
            final Integer i2 = Integer.valueOf(nodes[1]);
            if (!unionFind.areConnected(i1, i2)) {
                unionFind.union(i1, i2);
            }
        }
        return unionFind;
    }

}
