package com.jyril;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jyril81 on 27.05.2015.
 */
public class PositionFinderTest {

    @Test
    public void findsPositionIfElementExists() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(6);

        int pos = PositionFinder.findPosition(input, 5);

        assertEquals(2, pos);
    }

    @Test
    public void findsPositionIfNoElementButShouldBeAtStart() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(6);

        int pos = PositionFinder.findPosition(input, 0);

        assertEquals(0, pos);
    }

    @Test
    public void findsPositionIfNoElementButShouldBeAtEnd() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(6);

        int pos = PositionFinder.findPosition(input, 7);

        assertEquals(4, pos);
    }

    @Test
    public void findsPositionIfNoElementButShouldBeInMiddle() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(6);

        int pos = PositionFinder.findPosition(input, 2);

        assertEquals(1, pos);
    }

    @Test
    public void findsPositionIfNoElementButShouldBeInMiddle2() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        input.add(6);

        int pos = PositionFinder.findPosition(input, 4);

        assertEquals(2, pos);
    }
}
