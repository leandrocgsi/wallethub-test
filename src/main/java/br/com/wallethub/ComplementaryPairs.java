package br.com.wallethub;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
    
    public class ComplementaryPair {
        
        public int pairOne;
        public int pairTwo;

        public ComplementaryPair(int addendOne, int addendTwo) {
            this.pairOne = addendOne;
            this.pairTwo = addendTwo;
        }

        public int sum() {
            return pairOne + pairTwo;
        }

        @Override
        public String toString() {
            return pairOne + " + " + pairTwo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ComplementaryPair that = (ComplementaryPair) o;

            List<Integer> numbersList = Arrays.asList(that.pairOne, that.pairTwo, pairOne, pairTwo);
            
            Set<Integer> numbersSet = new HashSet<>(numbersList);

            return numbersSet.size() <= 2;

        }

        @Override
        public int hashCode() {
            int result = pairOne + pairTwo;
            result = 31 * result;
            return result;
        }
    }
}