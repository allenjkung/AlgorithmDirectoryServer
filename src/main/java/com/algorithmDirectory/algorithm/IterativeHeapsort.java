package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;

public class IterativeHeapsort {
    public static void IterativeSiftDown(int[] arr, int root, int lastIndex) {
        int currentIndex = root;

        while(true) {
            int leftIndex = ((currentIndex * 2) + 1);
            int rightIndex = ((currentIndex * 2) + 2);
            int largestIndex = currentIndex;
        
            if(leftIndex < lastIndex && arr[leftIndex] > arr[largestIndex]) {
                largestIndex = leftIndex;
            }
            if(rightIndex < lastIndex && arr[rightIndex] > arr[largestIndex]) {
                largestIndex = rightIndex;
            }

            if(largestIndex == currentIndex) {
                break;
            }

            int tempVal = arr[currentIndex];
            arr[currentIndex] = arr[largestIndex];
            arr[largestIndex] = tempVal;
            currentIndex = largestIndex;
        }
    }
    
    public static void IterativeHeapsort(int[] arr) {
        int arrLength = arr.length;
        
        for(int i = ((arrLength / 2) - 1); i >= 0; i -= 1) {
            IterativeSiftDown(arr, i, arrLength);
        }

        for(int i = (arrLength - 1); i >= 0; i -= 1) {
            int tempVal = arr[0];
            arr[0] = arr[i];
            arr[i] = tempVal;
            IterativeSiftDown(arr, 0, i);
        }
    }

    public static List<int[]> IterativeHeapsortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int arrLength = arr.length;
        
        for(int i = ((arrLength / 2) - 1); i >= 0; i -= 1) {
            IterativeSiftDown(arr, i, arrLength);
        }
        loopSteps.add(arr.clone());

        for(int i = (arrLength - 1); i >= 0; i -= 1) {
            int tempVal = arr[0];
            arr[0] = arr[i];
            arr[i] = tempVal;
            IterativeSiftDown(arr, 0, i);
            loopSteps.add(arr.clone());
        }

        return loopSteps;
    }
}