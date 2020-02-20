import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("mobydick.txt");

        BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));

        Set<String> wordsOfMobydick = new HashSet<>();

        String line = reader.readLine();
        int totalLines = 0;
        int totalWords = 0;

        while (line != null) {
            System.out.println("Processing line: " + line);
            // if there is actual content in the line
            if (!line.trim().equals("")) {
                String [] words = line.split(" ");
                totalWords += words.length;

                for (String word : words) {
                    String cleanUpWords = word.toLowerCase()
                            .replace(",", "")
                            .replace(":", "")
                            .replace("\"", "")
                            .replace(";", "")
                            .replace(".", "")
                            .replace("-", "");

                    wordsOfMobydick.add(cleanUpWords);
                }
            }

            totalLines++;
            line = reader.readLine();
        }

        System.out.println(wordsOfMobydick);

        System.out.println();
        System.out.println("How many unique words were in the text?");
        System.out.println(wordsOfMobydick.size());

        System.out.println();

        System.out.println("Total lines: ");
        System.out.println(totalLines);

        System.out.println();

        System.out.println("Total words: ");
        System.out.println(totalWords);

        System.out.println("");

    }
}