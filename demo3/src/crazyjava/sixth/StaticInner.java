package crazyjava.sixth;

public class StaticInner extends Wolf{

	public static void info(){
		System.out.println("staticInner info()");
	}
	public static void main(String args[]){
		Wolf w1 = new Wolf();
		Wolf w2 = new StaticInner();
		w1.info();
		w2.info();
	}
}
