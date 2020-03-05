package com.sbt.jschool.lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class lesson3_6 {
    public static void main (String[] Args) throws IOException {
        String fileName = "C:\\sbr_sc\\test\\123.txt";
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, content.split(" "));
        Scanner sc = new Scanner(System.in);
        while (true){
            String x = sc.next();
            if (x.equals("exit")) break;
            System.out.println(stringList.get(Integer.parseInt(x)));
        }
    }
}
