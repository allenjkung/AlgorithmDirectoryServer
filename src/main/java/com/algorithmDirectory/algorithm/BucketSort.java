package com.alogrithmDirectory.algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void BucketSort(int[] arr) {
        int bucketCount = 100;
        int arrLength = arr.length;
        int minVal = arr[0];
        int maxVal = arr[0];
        for(int i = 0; i < arrLength; i += 1) {
            if(minVal > arr[i]) {
                minVal = arr[i];
            }
            if(maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }
        if(minVal == maxVal) {
            return;
        }
        int j = 0;
        float steps = ((maxVal - minVal) / (float)bucketCount);
        if(steps > 0) {
            List<ArrayList<Integer>> buckets = new ArrayList();
            for(int i = 0; i <= bucketCount; i += 1) {
                buckets.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < arrLength; i += 1) {
                int bucketId = (int)((arr[i] - minVal) / steps);
                buckets.get(bucketId).add(arr[i]);
            }
            for(int i = 0; i <= bucketCount; i += 1) {
                ArrayList<Integer> bucket = buckets.get(i);
                Collections.sort(bucket);
                for(int val: bucket) {
                    arr[j] = val;
                    j += 1;
                }
            }
        }
        else {
            bucketCount = (maxVal - minVal);
            int[] buckets = new int[bucketCount + 1];
            for(int i = 0; i < arrLength; i += 1) {
                buckets[arr[i] - minVal] += 1;
            }
            for(int bucketId = 0; bucketId <= bucketCount; bucketId += 1) {
                int totalCount = buckets[bucketId];
                for(int i = 0; i < totalCount; i += 1) {
                    arr[j] = (bucketId + minVal);
                    j += 1;
                }
            }
        }
    }

    public static List<int[]> BucketSortSteps(int[] arr) {
        List<int[]> loopSteps = new ArrayList<int[]>();
        loopSteps.add(arr.clone());
        int bucketCount = 100;
        int arrLength = arr.length;
        int minVal = arr[0];
        int maxVal = arr[0];
        for(int i = 0; i < arrLength; i += 1) {
            if(minVal > arr[i]) {
                minVal = arr[i];
            }
            if(maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }
        if(minVal == maxVal) {
            return loopSteps;
        }
        int j = 0;
        float steps = ((maxVal - minVal) / (float)bucketCount);
        if(steps > 0) {
            List<ArrayList<Integer>> buckets = new ArrayList();
            for(int i = 0; i <= bucketCount; i += 1) {
                buckets.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < arrLength; i += 1) {
                int bucketId = (int)((arr[i] - minVal) / steps);
                buckets.get(bucketId).add(arr[i]);
            }
            for(int i = 0; i <= bucketCount; i += 1) {
                ArrayList<Integer> bucket = buckets.get(i);
                Collections.sort(bucket);
                for(int val: bucket) {
                    arr[j] = val;
                    j += 1;
                }
                if(bucket.size() > 0) {
                    loopSteps.add(arr.clone());
                }
            }
        }
        else {
            bucketCount = (maxVal - minVal);
            int[] buckets = new int[bucketCount + 1];
            for(int i = 0; i < arrLength; i += 1) {
                buckets[arr[i] - minVal] += 1;
            }
            for(int bucketId = 0; bucketId <= bucketCount; bucketId += 1) {
                int totalCount = buckets[bucketId];
                for(int i = 0; i < totalCount; i += 1) {
                    arr[j] = (bucketId + minVal);
                    j += 1;
                }
                if(totalCount > 0) {
                    loopSteps.add(arr.clone());
                }
            }
        }
        loopSteps.add(arr.clone());

        return loopSteps;
    }
}