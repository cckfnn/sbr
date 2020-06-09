package com.sbt.jschool.lesson6.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        CalculatorImpl calc = new CalculatorImpl();

        Calculator calcProxy = (Calculator) Proxy.newProxyInstance(calc.getClass().getClassLoader(),
                CalculatorImpl.class.getInterfaces(), new ProxyHandler(calc));

        System.out.println(calcProxy.fibRecursion(1));
        System.out.println(calcProxy.fibRecursion(30));
        System.out.println(calcProxy.fibRecursion(1));
        System.out.println(calcProxy.fibRecursion(10));
        System.out.println(calcProxy.fibRecursion(30));
        System.out.println(calcProxy.fibLocalCache(30));
    }
}
