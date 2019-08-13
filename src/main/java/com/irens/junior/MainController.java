package com.irens.junior;

import com.irens.junior.domain.GeneratingPalindromes;
import com.irens.junior.domain.Number;
import com.irens.junior.repos.NumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private NumberRepo numberRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @PostMapping
    public String add (
            @RequestParam BigInteger number,
            @RequestParam Integer numberOfPalindromes,
            @RequestParam(required = false, defaultValue = "") BigInteger minPalindrome,
            @RequestParam(required = false, defaultValue = "") BigInteger maxPalindrome,
            Model model
    ){

        if(number.intValue()%1 == 0 && number.intValue()>=0) {
                GeneratingPalindromes generatingPalindromes = new GeneratingPalindromes();
                List<BigInteger> closestPalindromes = generatingPalindromes.assertPalindrome(number, numberOfPalindromes);
                minPalindrome = Collections.min(closestPalindromes);
                maxPalindrome = Collections.max(closestPalindromes);

       }

        Number typedNumber = new Number(number, numberOfPalindromes, minPalindrome, maxPalindrome);

        numberRepo.save(typedNumber);

        Iterable<Number> numbers = numberRepo.findAll();

        model.addAttribute("numbers", numbers);

        return "main";
    }

    @GetMapping
    public String history(Model model) {

        Iterable<Number> numbers = numberRepo.findAll();

        model.addAttribute("numbers", numbers);

        return "main";
    }
}
//сделать проверку на минус, оформить визуально и добавить кнопки