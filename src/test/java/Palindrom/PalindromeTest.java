package Palindrom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PalindromeTest {
    Palindrome palindrome = new Palindrome();


@ParameterizedTest
@ValueSource(strings = {"123321, MOM"})
void TestIsPalindromeMethod(){
    Assertions.assertTrue(isPalindrome("01233210"));
}

@Test
boolean isPalindrome(String args) {
 Assertions.assertTrue(isPalindrome("123321"));
    Assertions.assertTrue(isPalindrome("01233210"));
    Assertions.assertTrue(isPalindrome("1233210"));
    return false;
}
}



