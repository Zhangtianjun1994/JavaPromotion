package crazyjava.fifth;

public class SynchronizedStatic implements Runnable{

	static boolean staticFlag = true;
	public static synchronized void test0() throws InterruptedException{
		for(int i=0;i<50;i++){
			System.out.println("test0:"+Thread.currentThread().getName()+" "+i);
			Thread.sleep(100);
		}
	}
	
	public void test1(){
		synchronized (SynchronizedStatic.class) {
			for(int i=0;i<50;i++){
				System.out.println("test1:"+Thread.currentThread().getName()+" "+i);
			}
		}
	}
	
	public void run(){
		if(staticFlag){
			staticFlag = false;
			try {
				test0();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			staticFlag = true;
			test1();
		}
	}
	
	public static void main(String args[]) throws InterruptedException{
		SynchronizedStatic ss = new SynchronizedStatic();
		new Thread(ss).start();
		Thread.sleep(1000);
		new Thread(ss).start();
	}
}
