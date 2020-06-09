package com.sbt.jschool.lesson6.proxy;

public interface Calculator {
    @Cache
    long fibRecursion(int i);

    long fibLocalCache(int i);
}
