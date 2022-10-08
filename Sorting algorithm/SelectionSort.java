package com.sorting.algorithm;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[]= {54,2,7,98,6,3,4,7,98,45,3,43,64,24,675,34,73,335,68,86,44,53,223};
		
		int ans[]=selectionSort(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+",");
			
		}
	}

	private static int[] selectionSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++)
		{
			int min=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[min]>arr[j])
				{
					min=j;
				}
				int temp=arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
		
		return arr;
	}

	
}
