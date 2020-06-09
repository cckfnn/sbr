package com.sbt.jschool.lesson3;

// Выведите на экран список различных слов файла, отсортированный по возрастанию их длины(компаратор сначала по длине
//слова, потом по тексту)

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Lesson3_2 {
    public static void main(String[] Args) throws IOException {
        String fileName = "C:\\sbr_sc\\test\\123.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, content.split(" "));
//        stringList.sort(String::compareToIgnoreCase);
//        stringList.sort(Comparator.comparingInt(String::length));
        stringList.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });
        for (String st : stringList) System.out.println(st);
    }
}
