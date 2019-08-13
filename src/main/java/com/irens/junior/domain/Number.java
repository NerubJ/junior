package com.irens.junior.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 0, message = "Number cannot be under 0")
    private BigInteger number;

    private Integer numberOfPalindromes;

    private BigInteger MinPalindrome;

    private BigInteger MaxPalindrome;

    public Number(BigInteger number, Integer numberOfPalindromes, BigInteger minPalindrome, BigInteger maxPalindrome) {
        this.number = number;
        this.numberOfPalindromes = numberOfPalindromes;
        MinPalindrome = minPalindrome;
        MaxPalindrome = maxPalindrome;
    }
}
