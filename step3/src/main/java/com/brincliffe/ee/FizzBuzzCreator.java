package com.brincliffe.ee;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzCreator {

    public static List<String> generate(Integer firstValue, Integer lastValue) {
        validateParameters(firstValue, lastValue);

        List<String> convertedValues = new ArrayList<String>();

        for(int nextInSequence = firstValue; nextInSequence <= lastValue; nextInSequence++) {
            String convertedValue = Integer.toString(nextInSequence);

            if(contains3(nextInSequence)) {
                convertedValue = "lucky";
            } else {
                if(isMultipleOf3(nextInSequence)) {
                    convertedValue = "fizz";
                }

                if(isMultipleOf5(nextInSequence)) {
                    convertedValue = "buzz";
                }

                if(isMultipleOf15(nextInSequence)) {
                    convertedValue = "fizzbuzz";
                }
            }

            convertedValues.add(convertedValue);
        }
        return convertedValues;
    }

    private static boolean contains3(int number) {
        String numberAsString = Integer.toString(number);
        return numberAsString.contains("3");
    }

    private static void validateParameters(Integer firstValue, Integer lastValue) {
        if (firstValue == null || lastValue == null) throw new IllegalArgumentException("firstValue or lastValue cannot be null");
        if (lastValue.compareTo(firstValue) < 0) throw new IllegalArgumentException("lastValue cannot be less than firstValue");
    }

    private static boolean isMultipleOf15(int nextInSequence) {
        return isMultipleOf3(nextInSequence) && isMultipleOf5(nextInSequence);
    }

    private static boolean isMultipleOf5(int number) {
        if(number == 0) {
            return false;
        } else {
            return (number % 5 == 0);
        }
    }

    private static boolean isMultipleOf3(int number) {
        if(number == 0) {
            return false;
        } else {
            return (number % 3 == 0);
        }

    }
}
