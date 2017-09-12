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
    }
}
