package com.jyril;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that combines two lists by alternatively taking elements.
 * For example: given the two lists [a, b, c] and [1, 2, 3], the function should return [a, 1, b, 2, c, 3].
 * This solution supports lists of different sizes (if one list runs out of elements remining lements
 * form other list are added to end of the result list)
 * Created by jyril81 on 11.05.2015.
 */
public class CombineLists {

    public List<? extends Object> combine(List<? extends Object> list1, List<? extends Object> list2) {
        if (list1.isEmpty()) {
            return list2;
        }

        if (list2.isEmpty()) {
            return list1;
        }

        //both lists are non-empty
        //how many alements can alternate before one of the lists runs out
        int sharedSize = list1.size() >= list2.size() ? list2.size() : list1.size();

        //print alternating list
        List<Object> resultList = new ArrayList<>(list1.size() + list2.size());
        int index = 0;
        while (index < sharedSize) {
            resultList.add(list1.get(index));
            resultList.add(list2.get(index));
            index++;
        }

        //now print remaining elements from longer list
        List<? extends Object> longerList = list1.size() >= list2.size() ? list1 : list2;

        while (index < longerList.size()) {
            resultList.add(longerList.get(index));
            index++;
        }

        return resultList;
    }


}
