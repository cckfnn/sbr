package com.sbt.jschool.lesson3;

// Выведите на экран список различных слов файла, отсортированный по возрастанию их длины(компаратор сначала по длине
//слова, потом по тексту

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lesson3_2 {
    public static void main (String[] Args) throws IOException {
        String fileName = "C:\\sbr_sc\\test\\123.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, content.split(" "));
        stringList.sort(String::compareToIgnoreCase);
        stringList.sort(Comparator.comparingInt(String::length));
        for (String st: stringList) System.out.println(st);
    }
}
