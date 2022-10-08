package com.sorting.algorithm;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {54,2,7,98,6,3,4,7,98,45,3,43,64,24,675,34,73,335,68,86,44,53,223};
		
		int ans[]=insertionSort(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+",");
			
		}
	}
	public static int[] insertionSort(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>temp)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		return arr;
	}

}
