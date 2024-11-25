package com.alogrithmDirectory.algorithm;

import java.util.Random;
import java.util.Deque;
import java.util.ArrayDeque;

import java.util.List;
import java.util.ArrayList;

public class IterativeQuicksort {
    private static Random random = new Random();

    public static int IterativePartition(int[] arr, int leftIndex, int rightIndex) {
        int pivotIndex = (random.nextInt(rightIndex - leftIndex) + leftIndex);
        int pivot = arr[pivotIndex];

        int i = leftIndex;
        int j = rightIndex;
        while(true) {
            while(arr[i] < pivot) {
                i += 1;
            }
            while(arr[j] > pivot) {
                j -= 1;
            }
            if(i >= j) {
                return j;
            }
            int tempVal = arr[i];
            arr[i] = arr[j];
            arr[j] = tempVal;
        }
    }

    public static void IterativeQuicksort(int[] arr) {
        Deque<int[]> stack = new ArrayDeque<int[]>();
        stack.push(new int[]{0, (arr.length - 1)});

        while(!stack.isEmpty()) {
            int[] indexes = stack.pop();
            int leftIndex = indexes[0];
            int rightIndex = indexes[1];

            if(leftIndex < rightIndex) {
                int pivotIndex = IterativePartition(arr, leftIndex, rightIndex);
                stack.push(new int[]{leftIndex, (pivotIndex - 1)});
                stack.push(new int[]{(pivotIndex + 1), rightIndex});
            }
        }
    }

    public static List<int[]> IterativeQuicksortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        Deque<int[]> stack = new ArrayDeque<int[]>();
        stack.push(new int[]{0, (arr.length - 1)});

        while(!stack.isEmpty()) {
            int[] indexes = stack.pop();
            int leftIndex = indexes[0];
            int rightIndex = indexes[1];

            if(leftIndex < rightIndex) {
                int pivotIndex = IterativePartition(arr, leftIndex, rightIndex);
                stack.push(new int[]{leftIndex, (pivotIndex - 1)});
                stack.push(new int[]{(pivotIndex + 1), rightIndex});
                loopSteps.add(arr.clone());
            }
        }
        return loopSteps;
    }
}