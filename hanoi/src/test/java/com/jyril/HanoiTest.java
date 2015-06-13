package com.jyril;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jyril81 on 13.06.2015.
 */
public class HanoiTest {

    @Test
    public void noDisksIsNoMoves() throws Exception {
        assertEquals(0, Hanoi.myhanoi(0, 1, 3, 2, 0));
    }

    @Test
    public void onwDiskIsOneMove() throws Exception {
        assertEquals(1, Hanoi.myhanoi(1, 1, 3, 2, 0));
    }

    @Test
    public void twoDisksIs3Moves() throws Exception {
        assertEquals(3, Hanoi.myhanoi(2, 1, 3, 2, 0));
    }

    @Test
    public void threeDisksIs7Moves() throws Exception {
        assertEquals(7, Hanoi.myhanoi(3, 1, 3, 2, 0));
    }

    @Test
    public void nDisksIs2PowernMinus1() throws Exception {
        int nrDisks = 10;
        assertEquals((int) Math.pow(2, 10) - 1, Hanoi.myhanoi(10, 1, 3, 2, 0));
    }

}