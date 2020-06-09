package com.sbt.jschool.lesson6;


public class Ex3 extends Runtime<Number> {
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";
    public static final String THURSDAY = "THURSDAY";
    public static final String FRIDAY = "FRIDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String SUNDAY = "Sunday";

    private boolean getBool(){
        return true;
    }

    public static void main(String[] args) {
        ReflectionChecker rc = new ReflectionChecker();
        rc.showClassMethods(Ex3.class);
        rc.showClassMethodsPrivate(Ex3.class);
        rc.showMethodsGetter(Ex3.class);
        rc.checkStringConstant(Ex3.class);
    }
}

