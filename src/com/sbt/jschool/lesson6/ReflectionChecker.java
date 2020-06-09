package com.sbt.jschool.lesson6;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionChecker {

    public void showClassName(Class<?> clazz) {
        System.out.println(clazz);
    }

    public void showClassName(Object object) {
        showClassName(object.getClass());
    }

    public void showClassGeneric(Class<?> clazz) {
        System.out.println("Параметры класса: " + Arrays.toString(clazz.getTypeParameters()));
    }

    public void showClassGeneric(Object object) {
        showClassGeneric(object.getClass());
    }

    public void showClassInterfaceGeneric(Class<?> clazz){
        System.out.println("Параметры интерфейса: " + Arrays.toString(clazz.getGenericInterfaces()));
    }
    public void showClassInterfaceGeneric(Object object){
       showClassInterfaceGeneric(object.getClass());
    }


    private void getModifiers(int mods) {
        if (Modifier.isAbstract(mods)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("final");
        }
        if (Modifier.isInterface(mods)) {
            System.out.println("interface");
        }
        if (Modifier.isNative(mods)) {
            System.out.println("native");
        }
        if (Modifier.isPrivate(mods)) {
            System.out.println("private");
        }
        if (Modifier.isProtected(mods)) {
            System.out.println("protected");
        }
        if (Modifier.isPublic(mods)) {
            System.out.println("public");
        }
        if (Modifier.isStatic(mods)) {
            System.out.println("static");
        }
        if (Modifier.isStrict(mods)) {
            System.out.println("strict");
        }
        if (Modifier.isSynchronized(mods)) {
            System.out.println("synchronized");
        }
        if (Modifier.isTransient(mods)) {
            System.out.println("transient");
        }
        if (Modifier.isVolatile(mods)) {
            System.out.println("volatile");
        }

    }

    public void showClassModifiers(Class<?> clazz) {
        getModifiers(clazz.getModifiers());
    }

    public void showClassModifiers(Object object) {
        showClassModifiers(object.getClass());
    }

    public void showClassMethodsDeclared(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Имя метода: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
            Type returnType = method.getGenericReturnType();

            if (returnType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for (Type typeArgument : typeArguments) {
                    System.out.println("Тип - параметр: " + typeArgument);
                }
            }
            System.out.println("==========");
        }
    }

    public void showClassMethodsDeclared(Object object) {
        showClassMethodsDeclared(object.getClass());
    }

    public void showClassMethods(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("Имя метода: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
            Type returnType = method.getGenericReturnType();

            if (returnType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for (Type typeArgument : typeArguments) {
                    System.out.println("Тип - параметр: " + typeArgument);
                }
            }
            System.out.println("==========");
        }
    }

    public void showClassMethods(Object object) {
        showClassMethods(object.getClass());
    }

    public void showClassMethodsPrivate(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPrivate(method.getModifiers())) {
                method.setAccessible(true);
                System.out.println("Имя private метода: " + method.getName());
                System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
                Type returnType = method.getGenericReturnType();

                if (returnType instanceof ParameterizedType) {
                    ParameterizedType type = (ParameterizedType) returnType;
                    Type[] typeArguments = type.getActualTypeArguments();
                    for (Type typeArgument : typeArguments) {
                        System.out.println("Тип - параметр: " + typeArgument);
                    }
                }
                System.out.println("==========");
            }
        }
    }

    public void showMethodsGetter(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                System.out.println("Имя геттера: " + method.getName());
                System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
                Type returnType = method.getGenericReturnType();

                if (returnType instanceof ParameterizedType) {
                    ParameterizedType type = (ParameterizedType) returnType;
                    Type[] typeArguments = type.getActualTypeArguments();
                    for (Type typeArgument : typeArguments) {
                        System.out.println("Тип - параметр: " + typeArgument);
                    }
                }
                System.out.println("==========");
            }
        }
    }

    public void showClassField(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            System.out.println("Имя поля: " + field.getName());
            System.out.println("Возвращаемый тип: " + field.getType());
            Type returnType = field.getGenericType();

            if (returnType instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for (Type typeArgument : typeArguments) {
                    System.out.println("Тип - параметр: " + typeArgument);
                }
            }
            System.out.println("==========");
        }
    }

    public void showClassField(Object object){
        showClassField(object.getClass());
    }


    public void showClassPackage(Class<?> clazz) {
        System.out.println(clazz.getPackage());
    }

    public void showClassPackage(Object object) {
        showClassPackage(object.getClass());
    }

    public void showClassInterface(Class<?> clazz) {
        for (Class<?> s : clazz.getInterfaces()) {
            System.out.println(s.toString());
        }
    }

    public void showClassInterface(Object object) {
        showClassInterface(object.getClass());
    }

    private List<Class<?>> getSuperclass(Class<?> clazz) {
        List<Class<?>> classArray = new ArrayList<>();
        classArray.add(clazz);
        while (clazz.getSuperclass() != null) {
            clazz = clazz.getSuperclass();
            classArray.add(clazz);
        }
        return classArray;
    }

    public void showSuperclasses(Class<?> clazz) {
        for (Class<?> s : getSuperclass(clazz)) {
            System.out.println(s.toString());
        }
    }

    public void showSuperclasses(Object object) {
        showSuperclasses(object.getClass());
    }

    public void checkStringConstant(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                    System.out.print(field.getName() + " ");
                    try {
                        System.out.println(field.getName().equals(field.get(clazz)));
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        }
    }

    public void checkStringConstant(Object object) {
        checkStringConstant(object.getClass());
    }


}
