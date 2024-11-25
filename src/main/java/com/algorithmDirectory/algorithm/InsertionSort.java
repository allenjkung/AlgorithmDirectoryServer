package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class InsertionSort {
    public static void InsertionSort(int[] arr) {
        int arrLength = arr.length;
        for(int i = 0; i < arrLength; i += 1) {
            int val = arr[i];
            int j = (i - 1);
            while(j >= 0 && val < arr[j]) {
                arr[(j + 1)] = arr[j];
                j -= 1;
            }
            arr[(j + 1)] = val;
        }
    }

    public static List<int[]> InsertionSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        for(int i = 0; i < arrLength; i += 1) {
            int val = arr[i];
            int j = (i - 1);
            while(j >= 0 && val < arr[j]) {
                arr[(j + 1)] = arr[j];
                j -= 1;
            }
            arr[(j + 1)] = val;
            loopSteps.add(arr.clone());
        }
        return loopSteps;
    }
}