package com.google.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Allocation {

    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int totalCases = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < totalCases; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int budget = Integer.parseInt(input[1]);
            input = bufferedReader.readLine().split(" ");
            List<Integer> arr = new ArrayList<>();
            for (String price : input) {
                arr.add(Integer.parseInt(price));
            }
            System.out.println("Case #" + (i+1) + ": " + allocation(n, budget, arr));
        }
    }

    private static int allocation (int n, int budget, List<Integer> arr) {
        int res = 0;
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < n; i++) {
            if (budget >= arr.get(i)) {
                res++;
                budget -= arr.get(i);
            }
        }
        return res;
    }
}
