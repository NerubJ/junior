package com.irens.junior.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class GeneratingPalindromes {

    public boolean  isPalindrome(BigInteger number) {
        String numberStr = String.valueOf(number);
        return numberStr.equals(new StringBuilder(numberStr).reverse().toString());
    }

    public BigInteger nextPalindrome(BigInteger number) {
        String num = String.valueOf(number);

        int len = num.length();

        String left = num.substring(0, len / 2);

        String middle = num.substring(len / 2, len - len / 2);

        String right = num.substring(len - len / 2);

        if (right.compareTo(reverse(left)) < 0)
            return new BigInteger(left + middle + reverse(left));

        String next = new BigInteger(left + middle).add(BigInteger.ONE).toString();
        return new BigInteger(next.substring(0, left.length() + middle.length())
                + reverse(next).substring(middle.length()));
    }

    private  String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public List<BigInteger> assertPalindrome(BigInteger number, int numberOfPalindromes){

        List<BigInteger> closestPalindromes = new ArrayList<>();

        if (isPalindrome(number)){
            closestPalindromes.add(number);
            numberOfPalindromes--;
        }

        for (int i = 0; i < numberOfPalindromes; i++) {
            closestPalindromes.add(nextPalindrome(number));
            number = nextPalindrome(number);
        }

        return closestPalindromes;
    }


}
