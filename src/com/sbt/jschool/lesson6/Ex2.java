package com.sbt.jschool.lesson6;
//Получить все возможные типы-параметры в объекте этого класса.

public class Ex2 {
    public static void main(String[] args) {
        ReflectionChecker rc = new ReflectionChecker();
        rc.showClassGeneric(Runtime.class);
        rc.showClassInterfaceGeneric(Runtime.class);
        rc.showClassMethodsDeclared(Runtime.class);
        rc.showClassField(Runtime.class);

        Runtime<Float> run = new Runtime<>();
        rc.showClassGeneric(run);
        rc.showClassInterfaceGeneric(run);
        rc.showClassMethodsDeclared(run);
        rc.showClassField(run);
    }
}
