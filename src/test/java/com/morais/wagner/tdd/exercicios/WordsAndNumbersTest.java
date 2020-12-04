package com.morais.wagner.tdd.exercicios;

import com.morais.wagner.tdd.exercicios.WordsAndNumbers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordsAndNumbersTest {

    @Test
    public void verifyCorrespondenceBetweenWordsAndNumbers() {
        WordsAndNumbers subject = new WordsAndNumbers();
        assertEquals(52, (int) subject.getWordNumberMap().get("Z"));
    }

    @Test
    public void verifyAlphabetCorrespondenceGenerator() {
        Map<String, Integer> letterNumberCorrespondenceMap = new HashMap<>();
        WordsAndNumbers.generateNumberCorrespondence(letterNumberCorrespondenceMap, 'a', 'd');
        assertEquals(3, (int) letterNumberCorrespondenceMap.get("c"));
    }

    @Test
    public void verifyWordSum() {
        WordsAndNumbers subject = new WordsAndNumbers();
        int expected = 15;
        assertEquals(expected, subject.generateWordSum("ab3cd55e"));
    }

    @Test
    public void verifyIfWordIsPrimeNumber() {
        WordsAndNumbers subject = new WordsAndNumbers();
        assertTrue(subject.isWordPrimeNumber("00E5Z3"));//31+52=83
    }

    @Test
    public void verifyIfWordIsHappy() {
        WordsAndNumbers subject = new WordsAndNumbers();
        assertTrue(subject.isWordPrimeNumber("00E5Z3"));//31+52=83
    }

    @Test
    public void verifyIfWordIsMultipleOf_3_Or_5() {
        WordsAndNumbers subject = new WordsAndNumbers();
        assertTrue(subject.isWordMultipleOf_3_Or_5("c"));
    }

}
