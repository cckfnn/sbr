package com.sbt.jschool.lesson6;
//Для класса String получить и вывести на экран:
//        1.	Все модификаторы типа
//        2.	Имя пакета
//        3.	Классы иерархии
//        4.	Реализуемые интерфейсы для класса и для его родителей

public class Ex1 {
    public static void main(String[] args) {
        ReflectionChecker rc = new ReflectionChecker();
        System.out.println("-------------------showClassName-------------------------");
        rc.showClassName(String.class);
        System.out.println("-------------------showClassPackage-------------------------");
        rc.showClassPackage(String.class);
        System.out.println("-------------------showClassModifiers-------------------------");
        rc.showClassModifiers(String.class);
        System.out.println("-------------------showClassInterface-------------------------");
        rc.showClassInterface(String.class);
        System.out.println("-------------------showSuperclasses-------------------------");
        rc.showSuperclasses(String.class);
    }
}
