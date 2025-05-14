package com.bharat.learning.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Quicksort
 * Time complexity 
 *      Worst case -> O(n^2)
 *      Best case  -> O(n log n)
 * 
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> unsortedList = List.of(2, 3, 4, 5, 7, 97, 1, 101, 8, 10);
        List<Integer> mutableList = new ArrayList<>(unsortedList); // Make it mutable for sorting
        quicksort(mutableList, 0, mutableList.size() - 1);
        System.out.println(mutableList);
    }

    private static void quicksort(List<Integer> list, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partitionIndex - 1);
            quicksort(list, partitionIndex + 1, endIndex);
        }
    }

    private static int partition(List<Integer> list, int startIndex, int endIndex) {
        int pivot = list.get(startIndex);
        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            while (i < list.size() && list.get(i) <= pivot) {
                i++;
            }
            while (j >= 0 && list.get(j) > pivot) {
                j--;
            }
            if (i < j) {
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, startIndex, j);
        return j;
    }
}
