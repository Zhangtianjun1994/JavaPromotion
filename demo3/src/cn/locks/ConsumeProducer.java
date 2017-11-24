package cn.locks;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumeProducer {

	private static Buffer buff = new Buffer();
	public static class ProducerTask implements Runnable{
		@Override
		public void run() {
			try{
			int i=1;
			while(true){
				System.out.println("producer writes"+i);
				buff.write(i++);
				Thread.sleep((int)Math.random()*1000);
			}
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				
			}
		}
		
	}
	
	private static class Consumer implements Runnable{

		@Override
		public void run() {
			try{
				while(true){
					System.out.println("buffer read"+buff.read());
					Thread.sleep((int)(Math.random()*1000));
				}
			}catch(InterruptedException e){
				
			}
		}
		
	}
	
	public static class Buffer{
		private static final int CAPACITY = 1;
		private LinkedList<Integer> queue = new LinkedList<Integer>();
		
		private static Lock lock = new ReentrantLock();
		private static Condition notEmpty = lock.newCondition();
		private static Condition notfull = lock.newCondition();
		
		public void write(int value){
			lock.lock();
			
			try{
				while(queue.size() == CAPACITY){
					System.out.println("Õ¾ÒÑ¾­ÂúÁË");
					notfull.await();
				}
				queue.addFirst(value);
				notEmpty.signal();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public int read(){
			int value = 0;
			lock.lock();
			
			try{
				while(queue.isEmpty()){
					System.out.println("the queue is empty");
					notEmpty.await();
				}
				value = queue.removeFirst();
				notfull.signal();
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				lock.unlock();
				return value;
			}
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(new ProducerTask());
		executor.execute(new Consumer());

	}

}
