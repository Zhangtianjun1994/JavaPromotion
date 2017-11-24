package crazyjava.sixth;

public class OuterBase {

	public class InnerBase extends OuterBase{
		public InnerBase(){
			System.out.println("gouzao :  InnerBase");
		}
	}
	
	public class InnerSub extends InnerBase{
		public InnerSub(){
			new OuterBase().super();
		}
		
	}
	public void test(){
		
		//outer.
		InnerBase inner = new InnerBase();
		InnerSub sub = new InnerSub();
	}
	
	public static void main(String args[]){
		OuterBase outer = new OuterBase();
		outer.test();
	}
}
