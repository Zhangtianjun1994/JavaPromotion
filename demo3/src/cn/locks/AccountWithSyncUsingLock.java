package cn.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import EDU.oswego.cs.dl.util.concurrent.Executor;

public class AccountWithSyncUsingLock {
	
	public static void main(String args[]){
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0;i<100;i++){
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();
		
		while(!executor.isTerminated()){}
		System.out.println(account.getBalance());
	}
	
	private static Account account = new Account();
	public static class AddAPennyTask implements Runnable{
		@Override
		public void run() {
			account.deposite(1);
		}
		
	}

	public static class Account{
		private static Lock lock = new ReentrantLock();//创建一个锁
		private int balance = 0;
		
		public int getBalance(){
			return balance;
		}
		
		public void deposite(int amount){
			lock.lock();//得到一个锁
			try{
				int newBalance = balance+amount;
				
				Thread.sleep(5);
				balance = newBalance;
			}catch(InterruptedException e){
				
			}finally{
				lock.unlock();//解锁
			}
		}
	}
}
