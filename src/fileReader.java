import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class fileReader {
    public static void main(String[] args) throws IOException {
        //creates the file reader needed
            BufferedReader bufferedReader = new BufferedReader(new FileReader(""));

            //creates a map to input words and integer
        Map<String, Integer> wordCount = new HashMap<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("[\\\\s.;,?:!()\\\"]+");
            for (String word : words) {
                word = word.trim();
                if (word.length() > 0) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
        }
        // sorting wordCounts by frequency
        Map<String, Integer> sortedWordCounts = wordCount.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // printing word and frequencies of all words
        System.out.printf("%-20s%15s\n", "Word", "Frequency");

        System.out.printf("%-20s%15s\n", "====", "=========");

        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {

            System.out.printf("%-20s%10s\n", entry.getKey(), entry.getValue());
        }

        bufferedReader.close();
        }
    }
