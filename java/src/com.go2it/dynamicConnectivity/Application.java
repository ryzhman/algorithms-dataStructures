package dynamicConnectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) throws IOException {
        final DataStructure dataStructure;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\oryzhkov\\Documents\\git\\algorithms\\java\\src\\resources\\tinyUF.txt"))) {
//            dataStructure = initQuickFindTree(bufferedReader);
//            dataStructure = initQuickUnionTree(bufferedReader);
//            dataStructure = initWeightenedQuickUnionTree(bufferedReader);
            dataStructure = initPathCompressionWeightenedQuickUnionTree(bufferedReader);
        }

        System.out.format("Shared component for %d and %d: ", 1, 5);
        System.out.println(dataStructure.findComponent(1, 5));
        System.out.println();
    }

    private static DataStructure initQuickFindTree(BufferedReader bufferedReader) throws IOException {
        int numberOfElems = Integer.parseInt(bufferedReader.readLine());
        QuickFind unionFind = new QuickFind(numberOfElems);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] nodes = line.split(" ");
            final Integer i1 = Integer.valueOf(nodes[0]);
            final Integer i2 = Integer.valueOf(nodes[1]);
            if (!unionFind.areConnected(i1, i2)) {
                unionFind.union(i1, i2);
//                    System.out.println(i1 + " - " + i2);
            }
        }
        return unionFind;
    }

    private static DataStructure initQuickUnionTree(BufferedReader bufferedReader) throws IOException {
        int numberOfElems = Integer.parseInt(bufferedReader.readLine());
        QuickUnion unionFind = new QuickUnion(numberOfElems);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] nodes = line.split(" ");
            final Integer i1 = Integer.valueOf(nodes[0]);
            final Integer i2 = Integer.valueOf(nodes[1]);
            if (!unionFind.areConnected(i1, i2)) {
                unionFind.union(i1, i2);
//                    System.out.println(i1 + " - " + i2);
            }
        }
        return unionFind;
    }

    private static DataStructure initWeightenedQuickUnionTree(BufferedReader bufferedReader) throws IOException {
        int numberOfElems = Integer.parseInt(bufferedReader.readLine());
        WeightenedQuickUnion weightenedQuickUnion = new WeightenedQuickUnion(numberOfElems);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] nodes = line.split(" ");
            final Integer i1 = Integer.valueOf(nodes[0]);
            final Integer i2 = Integer.valueOf(nodes[1]);
            if (!weightenedQuickUnion.areConnected(i1, i2)) {
                weightenedQuickUnion.union(i1, i2);
//                    System.out.println(i1 + " - " + i2);
            }
        }
        return weightenedQuickUnion;
    }

    private static DataStructure initPathCompressionWeightenedQuickUnionTree(BufferedReader bufferedReader) throws IOException {
        int numberOfElems = Integer.parseInt(bufferedReader.readLine());
        PathCompressionWeightenedQuickUnion weightenedQuickUnion = new PathCompressionWeightenedQuickUnion(numberOfElems);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] nodes = line.split(" ");
            final Integer i1 = Integer.valueOf(nodes[0]);
            final Integer i2 = Integer.valueOf(nodes[1]);
            if (!weightenedQuickUnion.areConnected(i1, i2)) {
                weightenedQuickUnion.union(i1, i2);
//                    System.out.println(i1 + " - " + i2);
            }
        }
        return weightenedQuickUnion;
    }
}
