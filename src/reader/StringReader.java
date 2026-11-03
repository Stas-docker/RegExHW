package reader;

import java.util.Scanner;

public class StringReader implements ConsoleReader {
    @Override
    public String readLine(final Scanner scanner) {
        String string = scanner.nextLine();
        while (string.isBlank()) {
            System.out.println("String cannot be blank, please enter something");
            string = scanner.nextLine();
        }
        return string;
    }

    @Override
    public String readText() {
        try (final Scanner scanner = new Scanner(System.in)) {
            String text = readLine(scanner);
            while (text.isBlank()) {
                System.out.println("Text cannot be empty, type something: ");
                scanner.next();
                text = readLine(scanner);
            }
            return text;
        }
    }
}
