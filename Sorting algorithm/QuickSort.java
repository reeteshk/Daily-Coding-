package com.sorting.algorithm;

public class QuickSort {

	public static void main(String[] args) {

	int arr[]= {54,2,7,98,6,3,4,7,98,45,3,43,64,24,675,34,73,335,68,86,44,53,223};
	for (int i = 0; i < arr.length; i++) {
		System.out.print(arr[i]+",");
	}
	System.out.println();
	quickSort(arr,0,arr.length-1);
	
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}

	public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
}
