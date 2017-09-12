package com.brincliffe.ee;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<String> convertedValues = FizzBuzzCreator.generate(1,20);
        String valuesForDisplay = "";
        for (String convertedValue : convertedValues) {
            valuesForDisplay = valuesForDisplay + convertedValue + " ";
        }
        System.out.println(valuesForDisplay);

        FizzBuzzCounter counter = new FizzBuzzCounter(convertedValues);
        System.out.println("fizz: " + counter.fizzCount());
        System.out.println("buzz: " + counter.buzzCount());
        System.out.println("fizzbuzz: " + counter.fizzBuzzCount());
        System.out.println("lucky: " + counter.luckyCount());
        System.out.println("integer: " + counter.integerCount());
    }
}
