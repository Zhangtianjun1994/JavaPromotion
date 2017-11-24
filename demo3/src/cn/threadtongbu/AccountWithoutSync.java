package cn.threadtongbu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import EDU.oswego.cs.dl.util.concurrent.SynchronizedBoolean;

public class AccountWithoutSync {

	public static Account account = new Account();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i<100;i++){
			executor.execute(new AddApennyTask());
		}
		executor.shutdown();
		
		while(!executor.isTerminated()){
			
		}

		System.out.println("Æ½ºâÊ½£º"+account.getBalance());
	}
	
	private static class Account{
		private int balance = 0;
		
		public int getBalance(){
			return balance;
		}
		
		public synchronized void  deopsit(int amount){
			int newBalance = balance+amount;
			
			try{
				Thread.sleep(5);
			}catch(InterruptedException e){
				
			}
			balance = newBalance;
		}
	}
	
	private static class AddApennyTask implements Runnable{

		
		
		@Override
		public void run() {
			//synchronized (account) {
				account.deopsit(2);
			//}
		}
		
	}

}
