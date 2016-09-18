package br.com.wallethub;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComplementaryPair {
    
    public int addendOne;
    public int addendTwo;

    public ComplementaryPair(int addendOne, int addendTwo) {
        this.addendOne = addendOne;
        this.addendTwo = addendTwo;
    }

    public int sum() {
        return addendOne + addendTwo;
    }

    @Override
    public String toString() {
        return addendOne + " + " + addendTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplementaryPair that = (ComplementaryPair) o;

        List<Integer> numbersList = Arrays.asList(that.addendOne, that.addendTwo, addendOne, addendTwo);
        
        Set<Integer> numbers = new HashSet<>(numbersList);

        return numbers.size() <= 2;

    }

    @Override
    public int hashCode() {
        int result = addendOne + addendTwo;
        result = 31 * result;
        return result;
    }
}
