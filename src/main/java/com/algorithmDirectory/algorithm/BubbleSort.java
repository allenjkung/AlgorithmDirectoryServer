package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class BubbleSort {
    public static void BubbleSort(int[] arr) {
        int arrLength = arr.length;
        int lastSwapped = (arrLength - 1);
        for(int i = 0; i < arrLength; i += 1) {
            int swapFlag = 0;
            for(int j = 0; j < lastSwapped; j += 1) {
                if(arr[j] > arr[(j + 1)]) {
                    int tempVal = arr[j];
                    arr[j] = arr[(j + 1)];
                    arr[(j + 1)] = tempVal;
                    swapFlag = (j + 1);
                }
            }
            if(swapFlag == 0) {
                return;
            }
            lastSwapped = swapFlag;
        }
    }

    public static List<int[]> BubbleSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        int lastSwapped = (arrLength - 1);
        for(int i = 0; i < arrLength; i += 1) {
            int swapFlag = 0;
            for(int j = 0; j < lastSwapped; j += 1) {
                if(arr[j] > arr[(j + 1)]) {
                    int tempVal = arr[j];
                    arr[j] = arr[(j + 1)];
                    arr[(j + 1)] = tempVal;
                    swapFlag = (j + 1);
                }
            }
            if(swapFlag == 0) {
                break;
            }
            lastSwapped = swapFlag;
            loopSteps.add(arr.clone());
        }
        return loopSteps;
    }
}