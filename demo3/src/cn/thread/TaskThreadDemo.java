
package cn.thread;

public class TaskThreadDemo {
	public static void main(String args[]){
	PrintChar printchar = new PrintChar('z',100);
	PrintNum printnum = new PrintNum(100);
	
	Thread thread1 = new Thread(printchar);
	Thread thread2 = new Thread(printnum);
	
	thread1.setPriority(Thread.MAX_PRIORITY);
	thread2.setPriority(Thread.MIN_PRIORITY);
	
	thread2.start();
	thread1.start();
	
	}

}
