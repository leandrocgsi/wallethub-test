package br.com.wallethub;

import java.util.HashSet;
import java.util.Set;

public class ComplementaryPairs {
    
    public Set<ComplementaryPair> findComplementaryPairs(int sum, int[] numbers) {

        if (numbers == null || numbers.length < 2) {
            return new HashSet<>();
        }

        Set<Integer> noneDuplicate = new HashSet<>();
        for(int number:numbers) {
            noneDuplicate.add(number);
        }

        Set<ComplementaryPair> complementaryPairs = new HashSet<>();
        for (Integer number: noneDuplicate) {
            if (number > sum) {
                continue;
            }

            int difference = sum - number;
            if (noneDuplicate.contains(difference)) {
                complementaryPairs.add(new ComplementaryPair(number, difference));
            }
        }

        return complementaryPairs;

    }
    
}
