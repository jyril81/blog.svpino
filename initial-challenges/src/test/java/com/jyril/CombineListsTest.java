package com.jyril;

import org.junit.Test;

import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by jyril81 on 11.05.2015.
 */
public class CombineListsTest {

    @Test
    public void testCombineBothEmpty() {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        CombineLists combineLists = new CombineLists();
        List<? extends Object> result = combineLists.combine(list1, list2);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testCombineFirstEmpty() {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        CombineLists combineLists = new CombineLists();
        List<? extends Object> result = combineLists.combine(list1, list2);
        assertEquals(list2, result);
    }

    @Test
    public void testCombineSecondEmpty() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<Integer> list2 = new ArrayList<>();

        CombineLists combineLists = new CombineLists();
        List<? extends Object> result = combineLists.combine(list1, list2);
        assertEquals(list1, result);
    }

    @Test
    public void testCombineListsOfSameSize() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        CombineLists combineLists = new CombineLists();
        List<Object> expectedResult = new ArrayList<>();
        expectedResult.add("a");
        expectedResult.add(1);
        expectedResult.add("b");
        expectedResult.add(2);
        expectedResult.add("c");
        expectedResult.add(3);
        List<? extends Object> result = combineLists.combine(list1, list2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCombinedListsFirstLonger() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        CombineLists combineLists = new CombineLists();
        List<Object> expectedResult = new ArrayList<>();
        expectedResult.add("a");
        expectedResult.add(1);
        expectedResult.add("b");
        expectedResult.add(2);
        expectedResult.add("c");
        List<? extends Object> result = combineLists.combine(list1, list2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCombineListsSecondLonger() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        CombineLists combineLists = new CombineLists();
        List<Object> expectedResult = new ArrayList<>();
        expectedResult.add("a");
        expectedResult.add(1);
        expectedResult.add("b");
        expectedResult.add(2);
        expectedResult.add(3);
        List<? extends Object> result = combineLists.combine(list1, list2);
        assertEquals(expectedResult, result);
    }
}
