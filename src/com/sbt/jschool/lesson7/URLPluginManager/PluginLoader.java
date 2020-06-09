package com.sbt.jschool.lesson7.URLPluginManager;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader extends URLClassLoader {

    public PluginLoader(URL[] urls) {
        super(urls);
    }


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("my")) {
            System.out.println("\nЗагружаем " + name);
            return findClass(name);
        }
        System.out.println("Делегируем загрузку " + name);
        return super.loadClass(name);
    }
}
