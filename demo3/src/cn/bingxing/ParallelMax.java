package cn.bingxing;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMax {

	public static void main(String[] args) {
		final int size = 7000000;
		int list1[] = new int[size];
		for(int i=0;i<list1.length;i++){
			list1[i]= (int)(Math.random()*10000000);
		}
		long startTime = System.currentTimeMillis();
		
		System.out.println("最大值是"+parallelmax(list1));
		long endTime = System.currentTimeMillis();
		
		System.out.println("查找最大值的时间"+(endTime-startTime));
	}
	
	public static Integer parallelmax(int list[]){
		MaxTask maintask = new MaxTask(list);//创建一个任务
		ForkJoinPool pool = new ForkJoinPool();//创建用于执行任务的forkjoinpool
		return (Integer) pool.invoke(maintask);
		
	
	}
	public static class MaxTask extends RecursiveTask{//创建不返回值的任务
		private final int THRESHOLD = 1000;
		private int []list;
		public MaxTask(int []list) {
			this.list = list;
		}
		@Override
		protected Integer compute() {
			if(list.length<THRESHOLD){
				int max = list[0];
				for(int i=1;i<list.length;i++){
					if(list[i] > max)
						max = list[i];
					
				}
				return (Integer)max;
			}else{
				int firstHalf[] = new int[list.length/2];
				System.arraycopy(list, 0, firstHalf, 0, list.length/2);
				
				int secondLength = list.length - firstHalf.length;
				int secondHalf[] = new int[secondLength];
				System.arraycopy(list,list.length/2,secondHalf,0,secondLength);
				RecursiveTask<Integer> task1 = new MaxTask(firstHalf);
				RecursiveTask<Integer> task2 = new MaxTask(secondHalf);
				
				task1.fork();
				task2.fork();
				
				return (Math.max(task1.join().intValue(),task2.join().intValue()));
				//invoke(new MaxTask(firstHalf),new MaxTask(secondHalf));
				//Math.ma
				//MergeSort.merge(firstHalf,secondHalf,list);
			}
			
			
		}
	}

}
