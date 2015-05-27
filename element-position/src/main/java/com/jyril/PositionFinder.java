package com.jyril;

import java.util.List;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * There won't be duplicate values in the array.
 * <p>
 * For example:
 * <p>
 * [1, 3, 5, 6] with target value 5 should return 2.
 * [1, 3, 5, 6] with target value 2 should return 1.
 * [1, 3, 5, 6] with target value 7 should return 4.
 * [1, 3, 5, 6] with target value 0 should return 0.
 * <p>
 * Created by jyril81 on 27.05.2015.
 */
public class PositionFinder {
    public static int findPosition(List<Integer> input, int element) {
        int size = input.size();
        for (int i = 0; i < size; i++) {
            Integer elementAt = input.get(i);
            if (elementAt.equals(element)) {
                return i;
            }

            if (elementAt > element) {
                return i;
            }
        }
        return size;
    }
}
