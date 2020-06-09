package com.sbt.jschool.lesson7.URLPluginManager;

import java.io.IOException;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        try {
            String current = Paths.get("").toAbsolutePath().toString();

            PluginManager pluginManager = new PluginManager
                    (current + "\\src\\com\\sbt\\jschool\\lesson7\\URLPluginManager\\plugins");

            pluginManager.FindAndLoadClass();

//            Plugin a = pluginManager.load("A","my.A");
//            a.doUsefull();
//
//            Plugin b = pluginManager.load("B","my.B");
//            b.doUsefull();
//
//            Plugin pm = pluginManager.load("PluginManager","my.PluginManager");
//            pm.doUsefull();


        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IOException e) {
            e.printStackTrace();
        }
    }
}
