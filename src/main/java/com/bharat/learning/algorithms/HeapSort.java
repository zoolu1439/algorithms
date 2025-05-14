package com.bharat.learning.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Heapsort
 * Time complexity 
 *      Worst case -> O(n log n)
 * 
 */
public class HeapSort {

    public static void main(String[] args) {
        List<Integer> unsortedList = List.of(10, 6, 7, 5, 15, 17, 12);
        List<Integer> mutableList = new ArrayList<>(unsortedList); // Make it mutable for sorting

        sort(mutableList);

        System.out.println(mutableList);
    }

    private static void sort(List<Integer> list) {
        int n = list.size();

        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            Collections.swap(list, i, 0);

            // Call heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    private static void heapify(List<Integer> list, int n, int i) {
        int largest = i; // Initialize largest as root
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;

        // Check if left child exists and is greater than the root
        if (leftChildIndex < n && list.get(leftChildIndex) > list.get(largest)) {
            largest = leftChildIndex;
        }

        // Check if right child exists and is greater than the largest so far
        if (rightChildIndex < n && list.get(rightChildIndex) > list.get(largest)) {
            largest = rightChildIndex;
        }

        // If the largest is not the root
        if (largest != i) {
            Collections.swap(list, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
}