package com.sorting.algorithm;

public class BubbleSort {
	
	
	public static void main(String[] args) {
	
		int arr[]= {54,2,7,98,6,3,4,7,98,45,3,43,64,24,675,34,73,335,68,86,44,53,223};
		int ans[]=bubblesort(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+",");
		}
	}

	private static int[] bubblesort(int[] arr) {
		
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length-i;j++)
			{
				if(arr[j]<arr[i])
				{
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		return arr;
	}

}
