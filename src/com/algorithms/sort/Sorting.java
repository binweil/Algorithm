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
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
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

    /**
     * O(N*logN)
     * @param arr
     * @param start
     * @param end
     */
    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = arr[(start + end) / 2];
        int left = start, right = end;
        while (left <= right) {
            while ((left <= right) && (arr[left] < pivot)) {
                left++;
            }
            while ((left <= right) && (arr[right] > pivot)) {
                right--;
            }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }

        //Divide to subarray
        int mid = (start + end) / 2;
        mergeSort(arr, tmp, start, mid);
        mergeSort(arr, tmp, mid + 1, end);

        //Merge
        int head1 = start, head2 = mid+1;
        int index = 0;
        while ((head1 <= mid) && (head2 <= end)) {
            if (arr[head1] <= arr[head2]) {
                tmp[index++] = arr[head1++];
            } else {
                tmp[index++] = arr[head2++];
            }
        }
        while (head1 <= mid) {
            tmp[index++] = arr[head1++];
        }
        while (head2 <= end) {
            tmp[index++] = arr[head2++];
        }

        index = 0;
        while (start <= end) {
            arr[start++] = tmp[index++];
        }
    }
}
