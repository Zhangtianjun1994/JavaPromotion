package cn.locks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {
	
	private static ArrayBlockingQueue<Integer> buff = new ArrayBlockingQueue<>(2);
	
	public static class ProducerTask implements Runnable{

		@Override
		public void run() {
			try{
				int i=1;
				while(true){
					System.out.println("producer write "+i);
					buff.put(i++);
					Thread.sleep(100);
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public static class ConsumerTask implements Runnable{

		@Override
		public void run() {
			try{
				while(true){
				System.out.println("consumer take "+buff.take());
				//buff.take();
				Thread.sleep(200);
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		
		executor.shutdown();
	}


}
