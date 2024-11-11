package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class SelectionSort {
    public static int[] SelectionSort(int[] arr) {
        int arrLength = arr.length;
        for(int i = 0; i < arrLength; i += 1) {
            int minPos = i;
            for(int j = (i + 1); j < arrLength; j += 1) {
                if(arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            if(i != minPos) {
                int tempVal = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = tempVal;
            }
        }
        return arr;
    }

    public static List<int[]> SelectionSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        for(int i = 0; i < arrLength; i += 1) {
            int minPos = i;
            for(int j = (i + 1); j < arrLength; j += 1) {
                if(arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            if(i != minPos) {
                int tempVal = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = tempVal;
            }
            loopSteps.add(arr.clone());
        }
        return loopSteps;
    }
}