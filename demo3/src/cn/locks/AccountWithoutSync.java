package cn.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import EDU.oswego.cs.dl.util.concurrent.Semaphore;
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

		System.out.println("平衡式："+account.getBalance());
	}
	
	private static class Account{
		private int balance = 0;
		private static Semaphore semaphore = new Semaphore(1);//容量为1的信号量
		
		public int getBalance(){
			return balance;
		}
		
		public  void  deopsit(int amount){
			try{
				semaphore.acquire();
				int newBalance = balance+amount;
				Thread.sleep(5);
				balance = newBalance;
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				semaphore.release();
			}
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
