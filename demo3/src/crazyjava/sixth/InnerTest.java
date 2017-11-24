package crazyjava.sixth;

public class InnerTest extends InnerStaticClass.Inner{
	public InnerTest(){
		new InnerStaticClass().super();
	}
	
	public static void main(String args[]){
		InnerTest test = new InnerTest();
		System.out.println("jicheng"+test.toString());
	}
}
