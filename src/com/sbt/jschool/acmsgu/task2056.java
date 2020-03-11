package com.sbt.jschool.acmsgu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class task2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;
        while (sc.hasNext()) {
            String st = sc.next().toLowerCase();
            if (!map.containsKey(st)) {
                map.put(st, 0);
            }
            map.put(st, map.get(st) + 1);
            count = Math.max(count, map.get(st));
        }
        for (String st : map.keySet()) {
            if (map.get(st) == count) {
                System.out.println(st);
            }
        }
    }
}
