package com.algorithms.sort;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        int size = 100;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        System.out.println("Arrays is: " + Arrays.toString(arr));
    }
}
