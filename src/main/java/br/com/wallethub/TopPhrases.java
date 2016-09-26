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
        Map<String, Integer> frequency = new HashMap<>();

        Path path = Paths.get(folderPath, fileName);
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, charset)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] phrases = line.split("\\|");
                for (String phrase: phrases) {
                    if (!frequency.containsKey(phrase)) {
                        frequency.put(phrase, 1);
                    } else {
                        frequency.put(phrase, frequency.get(phrase) + 1);
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return new ArrayList<>();
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        
        Collections.sort(entries, (firstElement, secondElement) 
             -> Integer.compare(secondElement.getValue(), firstElement.getValue()));

        return entries
                .stream()
                .limit(100000)
                .collect(Collectors.toList());
    }
}