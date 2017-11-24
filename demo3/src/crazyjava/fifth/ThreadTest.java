package crazyjava.fifth;

public class ThreadTest extends Thread{
	private int i;
	public void run(){
		for(i=0;i<100;i++){
			System.out.print(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20){
				new ThreadTest().start();
				new ThreadTest().start();
			}
		}

	}

}
