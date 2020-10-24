package com.algorithms.sort;

import java.util.*;

public class Sorting {

    public static void main (String[] args) {
        int size = 10;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        long startTime = System.currentTimeMillis();
        //bubbleSort(arr);
        //insertSort(arr);
        //mergeSort(arr, new int[arr.length], 0, arr.length-1);
        //shellSort(arr, arr.length/2);
        heapSort(arr);
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
                    swap(arr, j, j+1);
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
                swap(arr, j, j + 1);
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
    private static void shellSort (int[] arr, int gap) {
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int j = i -gap;
                while ((j >= 0) && (arr[j] > arr[j+gap])) {
                    swap(arr, i, j + gap);
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
    private static void quickSort (int[] arr, int start, int end) {
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
                swap(arr, left, right);
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
    private static void mergeSort (int[] arr, int[] tmp, int start, int end) {
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

    /**
     * Heap Sort
     * Steps:
     * 1. Build a heap
     * 2. Swap the first element and the last element of the heap, which moves largest element to the tail
     * 3. Heapify [0, second last element]
     *
     * Time Complexity: O(N*logN)
     * Space Complexity: O(1)
     *
     * @param arr
     */
    private static void heapSort (int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
    }

    private static void heapify (int[] arr, int i, int n) {
        if (i >= n) {
            return;
        }

        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, n);
        }
    }

    private static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
