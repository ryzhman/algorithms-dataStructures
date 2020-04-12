package com.go2it.dynamicConnectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) throws IOException {
        final DataStructure unionFind;
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\oryzhkov\\Documents\\git\\algorithms\\resources\\tinyUF.txt"))) {
            //quickFind data structure
            unionFind = initQuickFindTree(bufferedReader);
        }

        if (unionFind == null) {
            System.out.println("Null");
        }
        System.out.format("Shared component for %d and %d: ", 1, 5);
        System.out.println(unionFind.findComponent(1, 5));
        System.out.println();
//        System.out.format("%d and %d are in the same component: %b", 3, 4, unionFind.areConnected(3, 4));
//        System.out.println();
//        System.out.format("%d and %d are in the same component: %b", 1, 5, unionFind.areConnected(1, 5));
//        System.out.println();
//        System.out.format("%d and %d are in the same component: %b", 7, 5, unionFind.areConnected(7, 5));
//        System.out.println();


    }

    private static DataStructure initQuickFindTree(BufferedReader bufferedReader) throws IOException {
        int numberOfElems = Integer.parseInt(bufferedReader.readLine());
        UnionQuickFind unionFind = new UnionQuickFind(numberOfElems);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] nodes = line.split(" ");
            final Integer i1 = Integer.valueOf(nodes[0]);
            final Integer i2 = Integer.valueOf(nodes[1]);
            if (!unionFind.areConnected(i1, i2)) {
                unionFind.eagerUnion(i1, i2);
//                    System.out.println(i1 + " - " + i2);
            }
        }
        return unionFind;
    }

}
