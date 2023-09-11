package com.java30.tankgame.multithread;

public class MultiThread {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println(cpuNums);

    }
}
