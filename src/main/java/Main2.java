import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        String fileName = "problem2.txt";

        int result = countSymbols(vowels, fileName);
        System.out.println(result);
    }

    public static int countSymbols(char[] vowelsArray, String fileName) {
        Set<Character> vowels = new HashSet<>();
        for (char c : vowelsArray) {
            vowels.add(c);
        }

        int countMax = 0;
        int lineNumber = 0;

        try (InputStream stream = Main2.class.getClassLoader().getResourceAsStream(fileName);
             InputStreamReader reader = new InputStreamReader(stream);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                int count = (int) line.chars()
                        .filter(c -> vowels.contains((char) c))
                        .count();

                if (count < countMax) {
                    continue;
                }

                countMax = count;
                lineNumber = currentLine;

                currentLine++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineNumber;
    }
}
