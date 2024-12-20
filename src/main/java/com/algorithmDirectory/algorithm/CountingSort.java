package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class CountingSort {
    public static void CountingSort(int[] arr) {
        int arrLength = arr.length;
        int maxVal = arr[0];
        for(int i = 0; i < arrLength; i += 1) {
            if(maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        int[] outputArr = new int[arrLength];
        int[] countArr = new int[maxVal + 1];
        for(int i = 0; i < arrLength; i += 1) {
            countArr[arr[i]] += 1;
        }
        for(int i = 1; i <= maxVal; i += 1) {
            countArr[i] += (countArr[i - 1]);
        }
        for(int i = (arrLength - 1); i >= 0; i -= 1) {
            int j = arr[i];
            countArr[j] -= 1;
            outputArr[countArr[j]] = arr[i];
        }

        for(int i = 0; i < arrLength; i += 1) {
            arr[i] = outputArr[i];
        }
    }

    public static List<int[]> CountingSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        int maxVal = arr[0];
        for(int i = 0; i < arrLength; i += 1) {
            if(maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        int[] outputArr = new int[arrLength];
        int[] countArr = new int[maxVal + 1];
        for(int i = 0; i < arrLength; i += 1) {
            countArr[arr[i]] += 1;
        }
        loopSteps.add(countArr.clone());
        for(int i = 1; i <= maxVal; i += 1) {
            countArr[i] += (countArr[i - 1]);
        }
        loopSteps.add(countArr.clone());
        for(int i = (arrLength - 1); i >= 0; i -= 1) {
            int j = arr[i];
            countArr[j] -= 1;
            outputArr[countArr[j]] = arr[i];
        }

        for(int i = 0; i < arrLength; i += 1) {
            arr[i] = outputArr[i];
        }
        loopSteps.add(arr.clone());
        return loopSteps;
    }
}