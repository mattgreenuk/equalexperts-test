package com.brincliffe.ee;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;

public class FizzBuzzCreatorTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test
    public void shouldRejectNullFirstValue() {
        Integer nullFirstValue = null;
        Integer lastValue = 10;

        exceptionGrabber.expect(IllegalArgumentException.class);

        FizzBuzzCreator.generate(nullFirstValue, lastValue);
    }

    @Test
    public void shouldRejectNullLastValue() {
        Integer firstValue = 1;
        Integer nullLastValue = null;

        exceptionGrabber.expect(IllegalArgumentException.class);

        FizzBuzzCreator.generate(firstValue, nullLastValue);
    }

    @Test
    public void shouldRejectNullFirstAndLastValues() {
        Integer nullFirstValue = null;
        Integer nullLastValue = null;

        exceptionGrabber.expect(IllegalArgumentException.class);

        FizzBuzzCreator.generate(nullFirstValue, nullLastValue);
    }

    @Test
    public void shouldRejectLastValueWhenLessThanFirstValue() {
        Integer firstValue = 5;
        Integer lowerLastValue = 4;

        exceptionGrabber.expect(IllegalArgumentException.class);

        FizzBuzzCreator.generate(firstValue, lowerLastValue);
    }

    @Test
    public void shouldReturnFizzWhenGivenAMultipleOf3() {
        List<String> convertedValues = FizzBuzzCreator.generate(3,3);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(1));
        assertThat(convertedValues.get(0), is("fizz"));
    }

    @Test
    public void shouldReturnBuzzWhenGivenAMultipleOf5() {
        List<String> convertedValues = FizzBuzzCreator.generate(5,5);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(1));
        assertThat(convertedValues.get(0), is("buzz"));
    }

    @Test
    public void shouldReturnFizzBuzzWhenGivenAMultipleOf15() {
        List<String> convertedValues = FizzBuzzCreator.generate(15,15);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(1));
        assertThat(convertedValues.get(0), is("fizzbuzz"));
    }

    @Test
    public void shouldReturnOriginalWhenGivenNonMultiple() {
        List<String> convertedValues = FizzBuzzCreator.generate(2,2);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(1));
        assertThat(convertedValues.get(0), is("2"));
    }

    @Test
    public void shouldReturnASequence() {
        List<String> convertedValues = FizzBuzzCreator.generate(1, 20);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(20));

        assertThat(convertedValues.get(0), is("1"));
        assertThat(convertedValues.get(1), is("2"));
        assertThat(convertedValues.get(2), is("fizz"));
        assertThat(convertedValues.get(3), is("4"));
        assertThat(convertedValues.get(4), is("buzz"));
        assertThat(convertedValues.get(5), is("fizz"));
        assertThat(convertedValues.get(6), is("7"));
        assertThat(convertedValues.get(7), is("8"));
        assertThat(convertedValues.get(8), is("fizz"));
        assertThat(convertedValues.get(9), is("buzz"));
        assertThat(convertedValues.get(10), is("11"));
        assertThat(convertedValues.get(11), is("fizz"));
        assertThat(convertedValues.get(12), is("13"));
        assertThat(convertedValues.get(13), is("14"));
        assertThat(convertedValues.get(14), is("fizzbuzz"));
        assertThat(convertedValues.get(15), is("16"));
        assertThat(convertedValues.get(16), is("17"));
        assertThat(convertedValues.get(17), is("fizz"));
        assertThat(convertedValues.get(18), is("19"));
        assertThat(convertedValues.get(19), is("buzz"));
    }

    @Test
    public void shouldReturnZeroWhenGivenZero() {
        List<String> convertedValues = FizzBuzzCreator.generate(0,0);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(1));
        assertThat(convertedValues.get(0), is("0"));
    }

    @Test
    public void shouldHandleNegativeRanges() {
        List<String> convertedValues = FizzBuzzCreator.generate(-5, 5);

        assertThat(convertedValues, is(notNullValue()));
        assertThat(convertedValues.size(), is(11));

        assertThat(convertedValues.get(0), is("buzz"));
        assertThat(convertedValues.get(1), is("-4"));
        assertThat(convertedValues.get(2), is("fizz"));
        assertThat(convertedValues.get(3), is("-2"));
        assertThat(convertedValues.get(4), is("-1"));
        assertThat(convertedValues.get(5), is("0"));
        assertThat(convertedValues.get(6), is("1"));
        assertThat(convertedValues.get(7), is("2"));
        assertThat(convertedValues.get(8), is("fizz"));
        assertThat(convertedValues.get(9), is("4"));
        assertThat(convertedValues.get(10), is("buzz"));
    }
}
