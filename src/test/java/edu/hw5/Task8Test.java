package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    public void testIsOddLength() {
        assertTrue(Task8.isOddLength("101"));
        assertFalse(Task8.isOddLength("10"));
        assertTrue(Task8.isOddLength("111"));
    }

    @Test
    public void testIsStartedWithZeroAndOddLengthOrStartedWithOneAndEvenLength() {
        assertTrue(Task8.isStartedWithZeroAndOddLengthOrStartedWithOneAndEvenLength("010"));
        assertFalse(Task8.isStartedWithZeroAndOddLengthOrStartedWithOneAndEvenLength("110"));
        assertFalse(Task8.isStartedWithZeroAndOddLengthOrStartedWithOneAndEvenLength("01"));
    }

    @Test
    public void testIsNumberOfZerosDivisibleByThree() {
        assertTrue(Task8.isNumberOfZerosDivisibleByThree("000"));
        assertFalse(Task8.isNumberOfZerosDivisibleByThree("001"));
        assertFalse(Task8.isNumberOfZerosDivisibleByThree("100"));
    }

    @Test
    public void testIsAnyStringExceptTwoOrThreeOnesInRow() {
        assertTrue(Task8.isAnyStringExceptTwoOrThreeOnesInRow("101010"));
        assertFalse(Task8.isAnyStringExceptTwoOrThreeOnesInRow("111"));
        assertTrue(Task8.isAnyStringExceptTwoOrThreeOnesInRow("011"));
    }

    @Test
    public void testIsEveryOddSymbolIsOne() {
        assertTrue(Task8.isEveryOddSymbolIsOne("10101"));
        assertFalse(Task8.isEveryOddSymbolIsOne("1001"));
        assertFalse(Task8.isEveryOddSymbolIsOne("010"));
    }

    @Test
    public void testDoesContainAtLeastTwoZerosAndLessThanTwoOnes() {
        assertTrue(Task8.doesContainAtLeastTwoZerosAndLessThanTwoOnes("010"));
        assertTrue(Task8.doesContainAtLeastTwoZerosAndLessThanTwoOnes("001"));
        assertFalse(Task8.doesContainAtLeastTwoZerosAndLessThanTwoOnes("111"));
    }

    @Test
    public void testHasNotTwoOnesInRow() {
        assertTrue(Task8.hasNotTwoOnesInRow("010"));
        assertFalse(Task8.hasNotTwoOnesInRow("110"));
        assertFalse(Task8.hasNotTwoOnesInRow("111"));
    }
}
