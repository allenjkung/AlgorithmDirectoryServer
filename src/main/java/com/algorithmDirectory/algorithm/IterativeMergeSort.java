package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class IterativeMergeSort {
    public static int[] IterativeMergeArr(int[] arr, int[] tempArr, int leftIndex, int middleIndex, int rightIndex) {
        int i = leftIndex;
        int j = middleIndex;
        for(int k = leftIndex; k < rightIndex; k += 1) {
            if(i < middleIndex && (j >= rightIndex || arr[i] <= arr[j])) {
                tempArr[k] = arr[i];
                i += 1;
            }
            else {
                tempArr[k] = arr[j];
                j += 1;
            }
        }
        return tempArr;
    }

    public static int[] IterativeMergeSort(int[] arr) {
        int arrLength = arr.length;
        int[] tempArr = new int[arrLength];
        for(int i = 0; i < arrLength; i += 1) {
            tempArr[i] = arr[i];
        }
        for(int i = 1; i < arrLength; i *= 2) {
            for(int j = 0; j < arrLength; j = (j + (i * 2))) {
                int middleIndex = (j + i) < arrLength ? (j + i) : arrLength;
                int rightIndex = (j + (i * 2)) < arrLength ? (j + (i * 2)) : arrLength;
                tempArr = IterativeMergeArr(arr, tempArr, j, middleIndex, rightIndex);
            }
            for(int j = 0; j < arrLength; j += 1) {
                arr[j] = tempArr[j];
            }
        }
        return arr;
    }

    public static List<int[]> IterativeMergeSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        int[] tempArr = new int[arrLength];
        for(int i = 0; i < arrLength; i += 1) {
            tempArr[i] = arr[i];
        }
        for(int i = 1; i < arrLength; i *= 2) {
            for(int j = 0; j < arrLength; j = (j + (i * 2))) {
                int middleIndex = (j + i) < arrLength ? (j + i) : arrLength;
                int rightIndex = (j + (i * 2)) < arrLength ? (j + (i * 2)) : arrLength;
                tempArr = IterativeMergeArr(arr, tempArr, j, middleIndex, rightIndex);
            }
            for(int j = 0; j < arrLength; j += 1) {
                arr[j] = tempArr[j];
            }
            loopSteps.add(arr.clone());
        }
        return loopSteps;
    }
}