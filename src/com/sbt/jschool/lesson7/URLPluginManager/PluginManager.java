package com.sbt.jschool.lesson7.URLPluginManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException,
            ClassNotFoundException, IllegalAccessException, InstantiationException {

        URL[] url = {new File(pluginRootDirectory + "\\" + pluginName + "\\").toURI().normalize().toURL()};

        PluginLoader pluginLoader = new PluginLoader(url);
        return (Plugin) pluginLoader.loadClass(pluginClassName).newInstance();
    }

    public void FindAndLoadClass()
            throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String pluginName;
        String pluginClassName;
        List<Path> paths = Files.walk(Paths.get(pluginRootDirectory))
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".class"))
                .collect(Collectors.toList());
        for (Path path : paths) {
            path = Paths.get(pluginRootDirectory).relativize(path);
            pluginName = path.getFileName().toString().split("\\.")[0];
            pluginClassName = Paths.get(pluginName).relativize(path)
                    .toString().split("\\.")[0].replace("\\", ".");
            load(pluginName, pluginClassName).doUsefull();
        }
    }
}
