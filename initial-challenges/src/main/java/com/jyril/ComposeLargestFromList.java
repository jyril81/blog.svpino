package com.jyril;

import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Write a function that given a list of non negative integers,
 * arranges them such that they form the largest possible number.
 * For example, given [50, 2, 1, 9], the largest formed number is 95021.
 * Created by jyril81 on 12.05.2015.
 */
public class ComposeLargestFromList {

    public BigInteger composeLargest(List<Integer> input) {

        Collections.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //convert both to string
                String s1 = o1.toString();
                String s2 = o2.toString();
                int s1Length = s1.length();
                int s2Length = s2.length();

                if (s1Length == s2Length) {
                    //we want descending order
                    return s2.compareTo(s1);
                }

                //find shortest
                if (s1Length < s2Length) {
                    //we want descending order
                    return compareInternal(s1, s2) * -1;
                } else {
                    return compareInternal(s2, s1);
                }
            }

            /**
             * Compare shorter with longer by matching it with partial longer starting from beginning of longer
             * @param shorter
             * @param longer
             * @return
             */
            private int compareInternal(String shorter, String longer) {
                int lengthDiff = longer.length() - shorter.length();

                for (int compareStartIndexInsideLonger = 0; compareStartIndexInsideLonger <= lengthDiff; compareStartIndexInsideLonger++) {
                    String compariosonPartFromLonger = longer.substring(compareStartIndexInsideLonger, compareStartIndexInsideLonger + shorter.length());
                    //we have found an answer if they are not equal
                    int result = shorter.compareTo(compariosonPartFromLonger);
                    if (result != 0) {
                        return result;
                    }
                }

                //the are equal
                return 0;
            }
        });

        String result = "";
        for (Integer integer : input) {
            result = result + integer;
        }

        return new BigInteger(result);
    }
}
