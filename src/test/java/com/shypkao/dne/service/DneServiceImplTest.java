package com.shypkao.dne.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DneServiceImplTest {

    private DneServiceImpl dneService;

    @BeforeEach
    public void setUp() {
        dneService = new DneServiceImpl();
    }

    @Test
    public void testHasDneSequenceReturnsFalseForEmptyArray() {
        int[] arr = {};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertFalse(result);
    }

    @Test
    public void testHasDneSequenceReturnsFalseForArrayWithLessThan3Elements() {
        int[] arr = {1, 2};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertFalse(result);
    }

    @Test
    public void testHasDneSequenceReturnsTrueForArrayWith3Elements() {
        int[] arr = {1, 3, 2};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertTrue(result);
    }

    @Test
    public void testHasDneSequenceReturnsFalseForArrayWithNoDneSequence() {
        int[] arr = {1, 2, 3, 4, 5};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertFalse(result);
    }

    @Test
    public void testHasDneSequenceReturnsTrueForArrayWithDneSequence() {
        int[] arr = {1, 2, 4, 3, 5};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertTrue(result);
    }

    @Test
    public void testHasDneSequenceReturnsTrueForArrayWithDneSequence2() {
        int[] arr = {5, 9, 2, 6};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertTrue(result);
    }

    @Test
    public void testHasDneSequenceReturnsTrueForArrayWithDneSequence3() {
        int[] arr = {9, 6, 3, 12, 10};
        boolean result = dneService.hasDneSequence(arr);
        Assertions.assertTrue(result);
    }

}
