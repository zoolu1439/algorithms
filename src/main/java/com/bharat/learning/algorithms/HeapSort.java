package com.bharat.learning.algorithms;

import java.util.Arrays;
/**
 * Heapsort
 * Time complexity 
 *      worst case -> nlogn
 *      
 * 
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] unsortedArray = {10,6,7,5,15,17,12};
		
		sort(unsortedArray);
		
		System.out.println(Arrays.toString(unsortedArray));
		
		
	}

	private static void sort(int[] unsortedArray) {
		
		for(int i=Math.abs(unsortedArray.length/2);i>=0;i--)	{
			heapify(unsortedArray,unsortedArray.length,i);
		}
		
		System.out.println(Arrays.toString(unsortedArray));
		
		for(int i=(unsortedArray.length-1);i>0;i--)	{
			swap(unsortedArray, i, 0);
			heapify(unsortedArray,i,0);
		}
	}
	
	private static void heapify(int[] unsortedArray, int n, int i) {
		// TODO Auto-generated method stub
		int leftChildIndex = 2*i+1;
		int rightChildIndex= 2*i+2;
		int largest = i;
		if(leftChildIndex<n){
			if(rightChildIndex<n){
				if(unsortedArray[rightChildIndex]>unsortedArray[leftChildIndex]){
					largest=rightChildIndex;
				}
				else{
					largest=leftChildIndex;
				}
			}
			else{
				largest=leftChildIndex;
			}
		}
		if(largest!=i){
			if(unsortedArray[largest]>unsortedArray[i]){
				swap(unsortedArray, i, largest);
				heapify(unsortedArray,n,largest);
				
			}
		}
		
				
		
	}

	private static void swap(int[] unsortedArray, int i, int j) {
		int temp = unsortedArray[i];
		unsortedArray[i]=unsortedArray[j];
		unsortedArray[j]=temp;
	}

}
