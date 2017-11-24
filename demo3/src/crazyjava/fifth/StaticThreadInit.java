package crazyjava.fifth;

public class StaticThreadInit {
	final static String website;
	static{
		website = "www.baidu.com";
		Thread t = new Thread(){
			public void run(){
				System.out.println("进入run方法");
				System.out.println(website);
				//website = "www.baidu.com";
				
				System.out.println("退出run方法");
			}
		};
		t.start();

	}
	
	
	public static void main(String args[]){
		System.out.println(StaticThreadInit.website);
	}
}
