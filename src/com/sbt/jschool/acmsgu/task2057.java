package com.sbt.jschool.acmsgu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class task2057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int size = sc.nextInt();
        for (int i=0; i<size; i++){
            if (sc.nextInt() == 1) queue.add(sc.nextInt());
            else System.out.println(queue.remove());
        }
    }
}