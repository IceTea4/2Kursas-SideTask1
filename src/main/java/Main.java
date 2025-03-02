import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        char symbol = 'r';
        String fileName = "problem1.txt";

        int result = countSymbols(symbol, fileName);
        System.out.println(result);
    }

    public static int countSymbols(char symbol, String fileName) {
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + fileName);
            }

            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            inputStream.close();

            return (int) content.chars()
                    .map(Character::toLowerCase)
                    .filter(c -> c == symbol)
                    .count();
        } catch (IOException e) {
            throw new RuntimeException("Error reading the file: " + fileName, e);
        }
    }
}
