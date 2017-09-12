package com.brincliffe.ee;

import java.util.List;

public class FizzBuzzCounter {

    private int fizzCount = 0;
    private int buzzCount = 0;
    private int fizzBuzzCount = 0;
    private int luckyCount = 0;
    private int integerCount = 0;

    public FizzBuzzCounter(List<String> convertedValues) {
        if(convertedValues == null) throw new IllegalArgumentException("convertedValues cannot be null");
        for (String convertedValue : convertedValues) {

            if(convertedValue == null) throw new IllegalArgumentException("unexpected null content");

            if(convertedValue.equals("fizz")) {
                fizzCount++;
            } else if(convertedValue.equals("buzz")) {
                buzzCount++;
            } else if(convertedValue.equals("fizzbuzz")) {
                fizzBuzzCount++;
            } else if(convertedValue.equals("lucky")) {
                luckyCount++;
            } else {
                if(notAnInteger(convertedValue)) throw new IllegalArgumentException("unexpected content: " + convertedValue);
                integerCount++;
            }
        }
    }

    private boolean notAnInteger(String convertedValue) {
       try{
           Integer.parseInt(convertedValue);
       } catch (NumberFormatException ex) {
           return true;
       }
       return false;
    }

    public int fizzCount() {
        return fizzCount;
    }

    public int buzzCount() {
        return buzzCount;
    }

    public int fizzBuzzCount() {
        return fizzBuzzCount;
    }

    public int luckyCount() {
        return luckyCount;
    }

    public int integerCount() {
        return integerCount;
    }
}
