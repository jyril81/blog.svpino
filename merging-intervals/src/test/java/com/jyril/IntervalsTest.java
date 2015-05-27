package com.jyril;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IntervalsTest {

    @Test
    public void mergeOneRangeProducesSameRange() throws Exception {
        Range r = new Range(1, 10);

        Set<Range> result = Intervals.mergeRanges(ImmutableSet.of(r));

        assertEquals(ImmutableSet.of(r), result);
    }

    @Test
    public void mergeWithContainingRangeProducesSameRange() {
        Range r1 = new Range(5, 12);
        Range r2 = new Range(8, 10);

        Set<Range> result = Intervals.mergeRanges(ImmutableSet.of(r1, r2));

        assertEquals(ImmutableSet.of(r1), result);
    }

    @Test
    public void mergeWithPartiallyIntersectingRangeProducesMergedRange() {
        Range r1 = new Range(1, 10);
        Range r2 = new Range(5, 17);

        Set<Range> result = Intervals.mergeRanges(ImmutableSet.of(r1, r2));

        assertEquals(ImmutableSet.of(new Range(1, 17)), result);
    }

    @Test
    public void mergeNonOverlappingRangesProducesSameRanges() {
        Range r1 = new Range(1, 10);
        Range r2 = new Range(15, 17);

        Set<Range> result = Intervals.mergeRanges(ImmutableSet.of(r1, r2));

        assertEquals(ImmutableSet.of(r1, r2), result);
    }

    @Test
    public void mergeRanges() {
        Range r1 = new Range(1, 3);
        Range r2 = new Range(2, 6);
        Range r3 = new Range(8, 10);
        Range r4 = new Range(7, 11);

        Set<Range> result = Intervals.mergeRanges(ImmutableSet.of(r1, r2, r3, r4));

        assertEquals(ImmutableSet.of(new Range(1, 6), r4), result);
    }
}
