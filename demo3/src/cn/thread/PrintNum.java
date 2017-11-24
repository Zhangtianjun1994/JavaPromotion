package cn.thread;



public class PrintNum implements Runnable {

	private int lastNum;
	public PrintNum(int lastNum){
		this.lastNum = lastNum;
	}
	@Override
	public void run() {
		for(int i=0;i<lastNum;i++){
			System.out.print(i+" ");
			Thread.yield();
		}
	}

}
