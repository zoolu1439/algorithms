package com.bharat.learning.algorithms;

import java.util.Arrays;

/**
 * Quicksort
 * Time complexity 
 *      worst case -> n^2
 *      best case  -> nlogn
 * 
 */
public class QuickSort 
{
    public static void main( String[] args )
    {
        
        int[] unsortedArray = {2,3,4,5,7,97,1,101,8,10};
        int startIndex = 0;
        int endIndex = unsortedArray.length-1;
        quicksort(unsortedArray,startIndex, endIndex);
        System.out.println(Arrays.toString(unsortedArray));
    }

	private static void quicksort(int[] unsortedArray, int startIndex, int endIndex) {
		if(startIndex<endIndex) 
		{
			
			int partitionIndex = partition(unsortedArray,startIndex,endIndex);
			quicksort(unsortedArray, startIndex, partitionIndex);
			quicksort(unsortedArray, partitionIndex+1, endIndex);
		}
		
	}

	private static int partition(int[] unsortedArray, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
			int i=startIndex;
			int j=endIndex;
			int pivot = unsortedArray[startIndex];
			while(i<j) {
				while(unsortedArray[i]<=pivot)
				 
				{
					i++;
				}
				
				while(unsortedArray[j]>pivot)
					 
				{
					j--;
				}
				if(i<j) {
					swap(unsortedArray,i,j);
				}
				
			}
			
			swap(unsortedArray,startIndex,j);
		
		return j;
	}

	private static void swap(int[] unsortedArray, int i, int j) {
		int temp = unsortedArray[i];
		unsortedArray[i]=unsortedArray[j];
		unsortedArray[j]=temp;
	}
}
