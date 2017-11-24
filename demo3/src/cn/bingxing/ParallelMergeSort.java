package cn.bingxing;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {

	public static void main(String[] args) {
		final int size = 7000000;
		int list1[] = new int[size];
		int list2[] = new int[size];
		
		for(int i=0;i<list1.length;i++){
			list1[i] = list2[i] = (int)(Math.random()*1000);
		}
		System.out.println("ceshi 1");
		long startTime = System.currentTimeMillis();
		
		parallelMergeSort(list1);
		long endTime = System.currentTimeMillis();
		
		System.out.println("hebingyongle"+(endTime-startTime));
		System.out.println("ceshi 2");
		Long startTime1 = System.currentTimeMillis();
		System.out.println("ceshi 3");
		MergeSort.mergeSort(list2);
		System.out.println("ceshi 4");
		Long endTime1 = System.currentTimeMillis();
		System.out.println("ceshi 5");
		System.out.println("guibingpaixu :"+(endTime1-startTime1));
//		for(int i=0;i<700;i++){
//			if(i%20 == 0)System.out.println();
//			System.out.print(list2[i]+" ");
//			
//		}
	}
	
	public static void parallelMergeSort(int list[]){
		RecursiveAction maintask = new SortTask(list);//创建一个任务
		ForkJoinPool pool = new ForkJoinPool();//创建用于执行任务的forkjoinpool
		pool.invoke(maintask);
		
	
	}
	public static class SortTask extends RecursiveAction{//创建不返回值的任务
		private final int THRESHOLD = 500;
		private int []list;
		public SortTask(int []list) {
			this.list = list;
		}
		@Override
		protected void compute() {
			if(list.length<THRESHOLD){
				MergeSort.mergeSort(list);
			}else{
				int firstHalf[] = new int[list.length/2];
				System.arraycopy(list, 0, firstHalf, 0, list.length/2);
				
				int secondLength = list.length - firstHalf.length;
				int secondHalf[] = new int[secondLength];
				System.arraycopy(list,list.length/2,secondHalf,0,secondLength);
				
				invokeAll(new SortTask(firstHalf),new SortTask(secondHalf));
				
				MergeSort.merge(firstHalf,secondHalf,list);
			}
			
			
		}
	}

}
