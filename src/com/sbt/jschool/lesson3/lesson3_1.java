package com.sbt.jschool.lesson3;

// Подсчитайте количество различных слов в файле

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;

public class lesson3_1 {
    public static void main(String[] Args) throws IOException {
        String fileName = "C:\\sbr_sc\\test\\123.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        HashSet<String> strSet = new HashSet<>();
        Collections.addAll(strSet, content.split(" "));
        System.out.println(strSet.size());
    }
}
