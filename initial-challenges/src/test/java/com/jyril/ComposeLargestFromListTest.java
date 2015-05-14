package com.jyril;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.Integer;
import java.lang.NumberFormatException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jyril81 on 12.05.2015.
 */
public class ComposeLargestFromListTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEmpty() {
        List<Integer> list = new ArrayList<>();

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        expectedException.expect(NumberFormatException.class);
        composeLargestFromList.composeLargest(list);
    }

    @Test
    public void testOneElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        BigInteger result = composeLargestFromList.composeLargest(list);
        assertEquals(BigInteger.TEN, result);
    }

    @Test
    public void testSameSizeElements() {
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(31);
        list.add(99);

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        BigInteger result = composeLargestFromList.composeLargest(list);
        assertEquals(new BigInteger("993113"), result);
    }

    @Test
    public void testDifferentlySizedElements() {
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(3);

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        BigInteger result = composeLargestFromList.composeLargest(list);
        assertEquals(new BigInteger("313"), result);
    }

    @Test
    public void testDifferentlySizedElementsWithSharedPrefix() {
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(134);

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        BigInteger result = composeLargestFromList.composeLargest(list);
        assertEquals(new BigInteger("13413"), result);
    }

    @Test
    public void testComplex1() {
        List<Integer> list = new ArrayList<>();
        list.add(420);
        list.add(42);
        list.add(423);

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        BigInteger result = composeLargestFromList.composeLargest(list);
        assertEquals(new BigInteger("42423420"), result);
    }

    @Test
    public void testComplex2() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(50);
        list.add(56);

        ComposeLargestFromList composeLargestFromList = new ComposeLargestFromList();
        BigInteger result = composeLargestFromList.composeLargest(list);
        assertEquals(new BigInteger("56550"), result);
    }


}