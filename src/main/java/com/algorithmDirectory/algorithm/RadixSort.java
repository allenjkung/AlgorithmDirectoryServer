package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class RadixSort {
    public static void CountingSort(int[] arr, int place) {
        int arrLength = arr.length;
        int[] outputArr = new int[arrLength];
        int[] countArr = new int[10];
        for(int i = 0; i < arrLength; i += 1) {
            int radixVal = ((arr[i] / place) % 10);
            countArr[radixVal] += 1;
        }
        for(int i = 1; i < 10; i += 1) {
            countArr[i] += countArr[i - 1];
        }
        for(int i = (arrLength - 1); i >= 0; i -= 1) {
            int radixVal = ((arr[i] / place) % 10);
            countArr[radixVal] -= 1;
            outputArr[countArr[radixVal]] = arr[i];
        }

        for(int i = 0; i < arrLength; i += 1) {
            arr[i] = outputArr[i];
        }
    }

    public static void RadixSort(int[] arr) {
        int arrLength = arr.length;
        int maxVal = arr[0];
        for(int i = 0; i < arrLength; i += 1) {
            if(maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        for(int i = 1; (maxVal / i) > 0; i *= 10) {
            CountingSort(arr, i);
        }
    }

    public static List<int[]> RadixSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        int maxVal = arr[0];
        for(int i = 0; i < arrLength; i += 1) {
            if(maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        for(int i = 1; (maxVal / i) > 0; i *= 10) {
            CountingSort(arr, i);
            loopSteps.add(arr.clone());
        }
        loopSteps.add(arr.clone());

        return loopSteps;
    }
}