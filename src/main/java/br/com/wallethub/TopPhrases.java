package br.com.wallethub;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopPhrases {
    
    public List<Map.Entry<String,Integer>> findTopHundredThousandFrequentPhrases(String folderPath, String fileName) {
        Map<String, Integer> occurrences = new HashMap<>();

        Path path = Paths.get(folderPath, fileName);
        try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] phrases = line.split("\\|");
                for (String phrase: phrases) {
                    if (!occurrences.containsKey(phrase)) {
                        occurrences.put(phrase, 1);
                    } else {
                        occurrences.put(phrase, occurrences.get(phrase) + 1);
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return Collections.emptyList();
        }

        List<Map.Entry<String, Integer>> hashMapEntries = new ArrayList<>(occurrences.entrySet());
        Collections.sort(hashMapEntries, (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        return hashMapEntries
                .stream()
                .limit(100000)
                .collect(Collectors.toList());
    }
}