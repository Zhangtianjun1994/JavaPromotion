package cn.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCooperation {
	
	private static Account account = new Account();
	
	public static void main(String args[]){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		
		executor.execute(new DepositeTask());
		executor.execute(new WithDrawTask());
		
		executor.shutdown();
	}
	
	public static class DepositeTask implements Runnable{

		@Override
		public void run() {
			try{
				while(true){
					account.deposite((int)(Math.random()*10));
					Thread.sleep(3000);
			}
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static class WithDrawTask implements Runnable{

		@Override
		public void run() {
			while(true){
				account.withdraw(8);
			}
		}
		
	}
	
	public static class Account {
		private int balance =0 ;
		private static Lock lock = new ReentrantLock();
		private static Condition newCondation = lock.newCondition();
		
		public int getBalance(){
			return balance;
		}
		
		public void withdraw(int amount){
			lock.lock();
			try{
				while(amount>balance){
					System.out.println("余额不足");
					newCondation.await();
				}
					balance-=amount;
					System.out.println("取出"+amount+",余额为"+balance);
				//int newBalance = balance+amount;
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
		
		public void deposite(int amount){
			lock.lock();
			try{
				int newBalance = balance + amount;
				balance = newBalance;
				System.out.println("存入前后金额为："+balance);
				newCondation.signalAll();
			}finally{
				lock.unlock();
			}
		}
	}

}
