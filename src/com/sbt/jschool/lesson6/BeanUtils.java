package com.sbt.jschool.lesson6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */

    public static void assign(Object to, Object from) {


        for (Method getMethod : from.getClass().getMethods()) {

            if (getMethod.getDeclaringClass() == Object.class) //Методы класса Object пропускаем
                continue;

            if (getMethod.getName().startsWith("get")) {
                System.out.println("Найден getter " + getMethod);

                String setterName = getMethod.getName().replace("get", "set");
                System.out.println("Поиск сеттера: " + setterName);


                for (Method setMethod : to.getClass().getMethods()) {
                    if (setMethod.getName().equals(setterName)) {
                        if (getMethod.getReturnType().isAssignableFrom(setMethod.getParameterTypes()[0])){
                            System.out.println("Найден сеттер: " + setMethod);

                            try {
                                setMethod.invoke(to, getMethod.invoke(from));
                                System.out.println("Значение установлено.");
                            } catch (IllegalAccessException e) {
                                System.out.println("Нет доступа к методу " + getMethod);
                            } catch (InvocationTargetException e) {
                                System.out.println("Возникли пробелемы с вызовом метода " + getMethod);
                            }
                        }
                    }
                }
            }
        }
    }
}
