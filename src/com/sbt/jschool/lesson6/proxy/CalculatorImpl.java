package com.sbt.jschool.lesson6.proxy;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    List<Long> localCache = new ArrayList<>();


    @Override
    public long fibRecursion(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        return this.fibRecursion(n - 2) + this.fibRecursion(n - 1);
    }

    @Override
    public long fibLocalCache(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        long a = 1;
        long b = 1;
        long sum = 0;
        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}


