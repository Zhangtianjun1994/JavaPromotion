package cn.thread;

import java.util.concurrent.*;

public class ExcuteDemo {
	public static void main(String args[]){
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(new PrintChar('z',100));
		executor.execute(new PrintNum(20));
		executor.execute(new PrintChar('w',100));
		
		executor.shutdown();
	
	}

}
