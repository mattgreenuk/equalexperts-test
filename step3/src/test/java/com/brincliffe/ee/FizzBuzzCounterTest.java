package com.brincliffe.ee;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;

public class FizzBuzzCounterTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test
    public void shouldRejectNullList() {
        List<String> nullConvertedValues = null;

        exceptionGrabber.expect(IllegalArgumentException.class);

        new FizzBuzzCounter(nullConvertedValues);
    }

    @Test
    public void shouldRejectListWithUnexpectedContents() {
        List<String> listWithUnexpectedContent = new ArrayList<String>();
        listWithUnexpectedContent.add("unexpected");

        exceptionGrabber.expect(IllegalArgumentException.class);

        new FizzBuzzCounter(listWithUnexpectedContent);
    }

    @Test
    public void shouldRejectListWithNullContents() {
        List<String> listWithNullContent = new ArrayList<String>();
        listWithNullContent.add(null);

        exceptionGrabber.expect(IllegalArgumentException.class);

        new FizzBuzzCounter(listWithNullContent);
    }

    @Test
    public void shouldReturnCountsOfZeroWhenGivenEmptyList() {
        List<String> emptyList = new ArrayList<String>();

        FizzBuzzCounter fizzBuzzCounter = new FizzBuzzCounter(emptyList);

        assertThat(fizzBuzzCounter, is(notNullValue()));
        assertThat(fizzBuzzCounter.fizzCount(), is(0));
        assertThat(fizzBuzzCounter.buzzCount(), is(0));
        assertThat(fizzBuzzCounter.fizzBuzzCount(), is(0));
        assertThat(fizzBuzzCounter.luckyCount(), is(0));
        assertThat(fizzBuzzCounter.integerCount(), is(0));
    }

    @Test
    public void shouldCountSingleFizz() {
        List<String> singleFizz =  FizzBuzzCreator.generate(6,6);

        FizzBuzzCounter counter = new FizzBuzzCounter(singleFizz);

        assertThat(counter.fizzCount(), is(1));
        assertThat(counter.buzzCount(), is(0));
        assertThat(counter.fizzBuzzCount(), is(0));
        assertThat(counter.luckyCount(), is(0));
        assertThat(counter.integerCount(), is(0));
    }

    @Test
    public void shouldCountSingleBuzz() {
        List<String> singleBuzz =  FizzBuzzCreator.generate(5,5);

        FizzBuzzCounter counter = new FizzBuzzCounter(singleBuzz);

        assertThat(counter.fizzCount(), is(0));
        assertThat(counter.buzzCount(), is(1));
        assertThat(counter.fizzBuzzCount(), is(0));
        assertThat(counter.luckyCount(), is(0));
        assertThat(counter.integerCount(), is(0));
    }

    @Test
    public void shouldCountSingleFizzBuzz() {
        List<String> singleFizzBuzz = FizzBuzzCreator.generate(15, 15);

        FizzBuzzCounter counter = new FizzBuzzCounter(singleFizzBuzz);

        assertThat(counter.fizzCount(), is(0));
        assertThat(counter.buzzCount(), is(0));
        assertThat(counter.fizzBuzzCount(), is(1));
        assertThat(counter.luckyCount(), is(0));
        assertThat(counter.integerCount(), is(0));
    }

    @Test
    public void shouldCountSingleLucky() {
        List<String> singleLucky = FizzBuzzCreator.generate(3, 3);

        FizzBuzzCounter counter = new FizzBuzzCounter(singleLucky);

        assertThat(counter.fizzCount(), is(0));
        assertThat(counter.buzzCount(), is(0));
        assertThat(counter.fizzBuzzCount(), is(0));
        assertThat(counter.luckyCount(), is(1));
        assertThat(counter.integerCount(), is(0));
    }

    @Test
    public void shouldCountSingleInteger() {
        List<String> singleInteger = FizzBuzzCreator.generate(1, 1);

        FizzBuzzCounter counter = new FizzBuzzCounter(singleInteger);

        assertThat(counter.fizzCount(), is(0));
        assertThat(counter.buzzCount(), is(0));
        assertThat(counter.fizzBuzzCount(), is(0));
        assertThat(counter.luckyCount(), is(0));
        assertThat(counter.integerCount(), is(1));
    }

    @Test
    public void shouldCountMultipleValues() {
        List<String> convertedValues = FizzBuzzCreator.generate(1,20);

        FizzBuzzCounter counter = new FizzBuzzCounter(convertedValues);

        assertThat(counter.fizzCount(), is(4));
        assertThat(counter.buzzCount(), is(3));
        assertThat(counter.fizzBuzzCount(), is(1));
        assertThat(counter.luckyCount(), is(2));
        assertThat(counter.integerCount(), is(10));
    }
}
