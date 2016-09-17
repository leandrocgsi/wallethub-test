package br.com.wallethub;

public class Palindrome {
    
    public boolean isPalindrome(String word) {
        String wordWithoutSpaces = removeSpaces(word);
        int size = wordWithoutSpaces.length();
        for (int i = 0; i < (size / 2); ++i) {
            if (wordWithoutSpaces.charAt(i) != wordWithoutSpaces.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String removeSpaces(String word) {
        return word.replaceAll("\\s+","");
    }
}
