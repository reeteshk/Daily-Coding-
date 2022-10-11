package com.sorting.algorithm;

public class MergeSort {
	public static void main(String[] args) {
		int arr[]= {54,2,7,98,6,3,4,7,98,45,3,43,64,24,675,34,73,335,68,86,44,53,223};
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println();
		mergeSort(arr,0,arr.length-1);
		
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+",");
			}
	}

	private static void mergeSort(int[] arr, int i, int j) {
		if(i>=j)
		{
			return;
		}
		int mid=i+(j-i)/2;
		mergeSort(arr,i,mid);
		mergeSort(arr,mid+1,j);
		conquer(arr,i,mid,j);
	}

	private static void conquer(int[] arr, int i, int mid, int j) {
		
		int merge[]=new int[j-i+1];
		int idx1=i;
		int idx2=mid+1;
		int x=0;
		while(idx1<=mid && idx2<=j)
		{
			if(arr[idx1]<=arr[idx2])
			{
				merge[x++]=arr[idx1++];
			}
			else
			{
				merge[x++]=arr[idx2++];
			}
		}
		while(idx1<=mid)
		{
			merge[x++]=arr[idx1++];
		}
		while(idx2<=j)
		{
			merge[x++]=arr[idx2++];
		}
		
		for(int p=0,q=i;p<merge.length;p++,q++)
		{
			arr[q]=merge[p];
		}
	}

}
