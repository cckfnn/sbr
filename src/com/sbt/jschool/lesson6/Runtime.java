package com.sbt.jschool.lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Runtime<T extends Number>
        implements Callable<Double> {
    private final List<Integer> integers = (ArrayList<Integer>) emptyList();

    public List<T> numbers() {return (ArrayList<T>) emptyList();}

    public List<String> strings() {return (ArrayList<String>) emptyList();}

    private List<?> emptyList(){
        return new ArrayList<>();
    }
    @Override
    public Double call() {return 0d;}

}

