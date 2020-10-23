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
        //mergeSort(arr, new int[arr.length], 0, arr.length-1);
        shellSort(arr, arr.length/2);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Arrays is: " + Arrays.toString(arr));
        System.out.println("Sorting duration: " + duration);
    }

    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * Stable
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
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     *
     * Stable
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
     * Insert sort is a special case in shell sort, where the gap is 1
     * Best Time Complexity: O(N) where array is already sorted
     * Average Time Complexity: O(N*logN)
     * Worst Time Complexity: O(N^2) where array is revere ordered
     * Space Complexity: O(1)
     *
     * Unstable
     */
    private static void shellSort(int[] arr, int gap) {
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i -gap;
                while ((j >= 0) && (arr[j] > arr[j+gap])) {
                    int tmp = arr[j];
                    arr[j] = arr[j+gap];
                    arr[j+gap] = tmp;
                    j--;
                }
            }
            gap /= 2;
        }
    }

    /**
     * Worst Time Complexity: O(N^2)
     * Average/Best Time Complexity: O(N*logN)
     * Space Complexity: O(N*logN)
     *
     * @param arr
     * @param start: 0
     * @param end: arr.length - 1
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

    /**
     * Time Complexity: O(N*logN)
     * Space Complexity: O(N)
     *
     * @param arr
     * @param tmp: new int[arr.length]
     * @param start: 0
     * @param end: arr.length - 1
     */
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
