package my;

import com.sbt.jschool.lesson7.URLPluginManager.Plugin;

public class PluginManager implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Plugin " + this.getClass() + " успешно запущен ...");
    }

}