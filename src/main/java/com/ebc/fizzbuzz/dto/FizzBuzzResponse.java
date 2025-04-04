package com.ebc.fizzbuzz.dto;

import java.util.List;

public class FizzBuzzResponse {
    private String description;
    private List<String> results;

    public FizzBuzzResponse(List<String> results) {
        this.description = "FizzBuzz es un juego donde los múltiplos de 3 se reemplazan con 'Fizz <.<', los de 5 con 'Buzz >.> ' y los de ambos con 'FizzBuzz >.<'";
        this.results = results;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
