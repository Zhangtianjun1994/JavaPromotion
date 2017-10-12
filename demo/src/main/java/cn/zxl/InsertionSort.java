package cn.zxl;

import java.util.Scanner;

public class InsertionSort {
	public static void insertionSort(int []array){
		for(int i=1;i<array.length;i++){
			int currentNum = array[i];
			int k;
			for(k=i-1;k>=0 && currentNum<array[k];k--){
				array[k+1] = array[k];
			}
			array[k+1] = currentNum;
		}
		for(int j=0;j<array.length;j++)
			System.out.println(array[j]+"  ");
	}
	
	public static void main(String args[]){
		System.out.println("input the number of the array:");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int a[] = new int[number];
		for(int i=0;i<number;i++)
			a[i] = in.nextInt();
		insertionSort(a);
	}

}
