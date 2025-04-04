package com.ebc.fizzbuzz.service;


import org.springframework.stereotype.Service;

import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FizzBuzzService {

    public List<String> getFizzBuzz(int limit) {
        return IntStream.rangeClosed(1, limit)
                .mapToObj(this::convertNumberToFizzBuzz)
                .collect(Collectors.toList());
    }

    private String convertNumberToFizzBuzz(int number) {
        if (number % 15 == 0) return "FizzBuzz >.<";
        if (number % 3 == 0) return "Fizz <.<";
        if (number % 5 == 0) return "Buzz >.>";
        return String.valueOf(number);
    }
}