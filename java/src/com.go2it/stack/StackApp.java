package stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class StackApp {

    public static void main(String[] args) throws IOException {
//        ArrBasedStackOfStrings stack = new ArrBasedStackOfStrings();
        LinkedListBasedStackOfStrings stack = new LinkedListBasedStackOfStrings();

        try (Scanner scanner = new Scanner(Files.newBufferedReader(Paths.get("C:\\Users\\oryzhkov\\Documents\\git\\algorithms\\java\\src\\resources\\tobe.txt")))) {
            while (scanner.hasNext()) {
                String value = scanner.next();
                if (value.equalsIgnoreCase("-")) {
                    System.out.println(stack.pop());
                } else {
                    stack.push(value);
                }
            }
        }

    }
}
