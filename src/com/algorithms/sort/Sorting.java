package com.algorithms.sort;

import java.util.*;

public class Sorting {

    public static void main(String[] args) {
        int size = 1000;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        long startTime = System.currentTimeMillis();
        insertSort(arr);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Arrays is: " + Arrays.toString(arr));
        System.out.println("Sorting duration: " + duration);
    }

    /**
     * O(n2)
     * @param arr
     */
    private static void bubbleSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    /**
     * O(N*logN)
     * @param arr
     */
    private static void insertSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i -1;
            while ((j >= 0) && (arr[j] > arr[j+1])) {
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
                j--;
            }
        }
    }
}
