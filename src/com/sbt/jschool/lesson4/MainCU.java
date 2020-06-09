package com.sbt.jschool.lesson4;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainCU {
    public static void main(String[] args) {
        List<Integer> rangeList = CollectionUtils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6);
        System.out.println(CollectionUtils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6));
        System.out.println("----------------------------");

        List<Integer> rangeList2 =
                CollectionUtils.range(Arrays.asList(9, 2, 4, 6, 7, 5, 11), 2, 9, Comparator.comparingInt(o -> o));
        System.out.println(rangeList2);
        System.out.println("----------------------------");

        CollectionUtils.addAll(rangeList, rangeList2);
        System.out.println(rangeList2);
        System.out.println("----------------------------");

        List<Integer> newList = CollectionUtils.newArrayList();
        System.out.println(CollectionUtils.indexOf(rangeList2, 10));
        System.out.println("----------------------------");

        CollectionUtils.add(rangeList2, 10);
        System.out.println(rangeList2);
        System.out.println("----------------------------");

        System.out.println(CollectionUtils.containsAll(rangeList2, rangeList));
        System.out.println("----------------------------");

        System.out.println(CollectionUtils.containsAny(rangeList2, rangeList));
        System.out.println("----------------------------");

        System.out.println(CollectionUtils.limit(rangeList2, 4));
    }
}
