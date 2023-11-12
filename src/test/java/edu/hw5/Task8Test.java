package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    void testFirstPatternMatching() {
        assertTrue(Task8.isMatchesFirst("010"));
        assertFalse(Task8.isMatchesFirst("110"));
        assertFalse(Task8.isMatchesFirst("01"));
    }

    @Test
    void testSecondPatternMatching() {
        assertTrue(Task8.isMatchesSecond("010"));
        assertFalse(Task8.isMatchesSecond("110"));
        assertFalse(Task8.isMatchesSecond("01"));
    }

    @Test
    void testThirdPatternMatching() {
        assertTrue(Task8.isMatchesThird("010"));
        assertFalse(Task8.isMatchesThird("1100"));
        assertFalse(Task8.isMatchesThird(""));
        assertFalse(Task8.isMatchesThird("101010101010"));
    }

    @Test
    void testFourthPatternMatching() {
        assertTrue(Task8.isMatchesFourth("010"));
        assertFalse(Task8.isMatchesFourth("111"));
        assertFalse(Task8.isMatchesFourth("110"));
    }

    @Test
    void testFifthPatternMatching() {
        assertTrue(Task8.isMatchesFifth("101"));
        assertFalse(Task8.isMatchesFifth("1001"));
    }

    @Test
    void testSixthPatternMatching() {
        assertTrue(Task8.isMatchesSixth("010"));
        assertTrue(Task8.isMatchesSixth("000"));
        assertTrue(Task8.isMatchesSixth("01"));
        assertTrue(Task8.isMatchesSixth("1000"));
        assertFalse(Task8.isMatchesSixth("11"));
    }

    @Test
    void testSeventhPatternMatching() {
        assertTrue(Task8.isMatchesSeventh("010"));
        assertFalse(Task8.isMatchesSeventh("111"));
        assertTrue(Task8.isMatchesSeventh("01010"));
        assertFalse(Task8.isMatchesSeventh("01011"));
    }
}
