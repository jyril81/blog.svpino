package com.jyril;


import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given a collection of intervals, write a function that merges all overlapping intervals and prints them out.
 * <p>
 * For example, given [1, 3], [2, 6], [8, 10], and [7, 11], the function should print [1, 6], [7, 11].
 * Or given [5, 12], and [8, 10] the function should print [5, 12].
 * <p>
 * You can assume that the first element of each interval is always less or equal than the second element of the interval.
 * Created by jyril81 on 26.05.2015.
 */
public class Intervals {


    public static Set<Range> mergeRanges(Set<Range> input) {
        Set<Range> output = new HashSet<>();
        for (Range range : input) {
            output = merge(output, range);
        }
        return output;
    }

    private static Set<Range> merge(Set<Range> merged, Range rnew) {
        Set<Range> result = new HashSet<>();
        //ranges in merged that intersect with rnew
        Set<Range> intersected = new HashSet<>();

        for (Range rold : merged) {
            if (rold.intersects(rnew)) {
                intersected.add(rold);
            }
        }

        if (intersected.isEmpty()) {
            //no intersections found, just append rnew
            result.addAll(merged);
            result.add(rnew);
        } else {
            //we have intersections
            //first store the ones that did not have intersections
            Set<Range> notintersected = notIntersected(merged, intersected);
            //since they all intersect with same given range rnew it means we can collapseIntoOne them all into one range together with rnew
            intersected.add(rnew);
            Range collapsed = collapseIntoOne(intersected);
            //new result is notintersected plus collapsed
            result.addAll(notintersected);
            result.add(collapsed);
        }

        return result;
    }


    private static Range collapseIntoOne(Set<Range> intersected) {
        //we are given set of intersectingranges
        //this means we can just compose one range from min to max
        Preconditions.checkArgument(!intersected.isEmpty());

        Iterator<Range> iterator = intersected.iterator();
        Range first = iterator.next();
        int start = first.getStart();
        int end = first.getEnd();

        while (iterator.hasNext()) {
            Range next = iterator.next();
            if (next.getStart() < start) {
                start = next.getStart();
            }

            if (next.getEnd() > end) {
                end = next.getEnd();
            }
        }

        return new Range(start, end);
    }

    private static Set<Range> notIntersected(Set<Range> merged, Set<Range> intersected) {
        Set<Range> notintersected = new HashSet<>(merged);
        notintersected.removeAll(intersected);
        return notintersected;
    }
}
