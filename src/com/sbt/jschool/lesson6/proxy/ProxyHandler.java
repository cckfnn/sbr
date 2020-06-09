package com.sbt.jschool.lesson6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxyHandler implements InvocationHandler {

    private final Map<Method, Map<Integer, Object>> cache = new HashMap<>();
    private final Object delegate;

    public ProxyHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<Integer, Object> map;
        if (method.isAnnotationPresent(Cache.class)) {
            if (cache.containsKey(method) && cache.get(method).containsKey((Integer)args[0])) {
                System.out.println("Результат получен из кэша");
                return cache.get(method).get((Integer)args[0]);
            }
            Object result = method.invoke(delegate, args);
            if (cache.containsKey(method)){
                cache.get(method).put((Integer)args[0], result);
            }

            else {
                map = new HashMap<>();
                map.put((Integer)args[0], result);
                cache.put(method, map);
            }
            System.out.println("Результат записан в кэш");
            return result;
        }
        System.out.println("Кэш не используется");
        return method.invoke(delegate, args);
    }
}
