package br.com.wallethub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {
    
    Palindrome palindrome;

    @Before
    public void setUp() {
        palindrome = new Palindrome();
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(palindrome.isPalindrome("CIVIC"));
        Assert.assertTrue(palindrome.isPalindrome("SUBI NO ONIBUS"));
        Assert.assertTrue(palindrome.isPalindrome("1221"));
        Assert.assertFalse(palindrome.isPalindrome("1121"));
    }
    
    @Test
    public void testRemoveSpaces() {
        Assert.assertEquals("SUBINOONIBUS", palindrome.removeSpaces("SUBI NO ONIBUS"));
        Assert.assertEquals("REMOVINGSPACES", palindrome.removeSpaces(" REMOVING SPACES "));
        Assert.assertEquals("WalletHub", palindrome.removeSpaces("Wallet Hub"));
    }
}
