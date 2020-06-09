package com.sbt.jschool.lesson3;

// Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lesson3_3 {
    public static void main(String[] Args) throws IOException {
        String fileName = "C:\\sbr_sc\\test\\123.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, content.split(" "));
        HashMap<String, Integer> strMap = new HashMap<>();
        for (String st : stringList) {
            strMap.merge(st, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> pair : strMap.entrySet())
            System.out.println(pair.getKey() + " : " + pair.getValue());
    }

}
