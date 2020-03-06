package com.sbt.jschool.lesson3;

// Выведите на экран все строки файла в обратном порядке

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class lesson3_4 {
    public static void main(String[] Args) throws IOException {
        String fileName = "C:\\sbr_sc\\test\\123.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, content.split(" "));
        Collections.reverse(stringList);
        for (String st :
                stringList) {
            System.out.println(st);
        }
    }
}
