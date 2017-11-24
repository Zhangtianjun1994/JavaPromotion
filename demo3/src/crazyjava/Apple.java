package crazyjava;

public class Apple extends Fruit {
	public void info(){
		System.out.println("apple ·½·¨");
		System.out.println(count);
		System.out.println(super.count);
		System.out.println(Fruit.count);
	}
	public void AccessSuperInfo(){
		super.info();
	}
	
	public Fruit getSuper(){
		return super.getThis();
	}

	String color = "red";
	static int count = 200;
	public static void main(String args[]){
		Apple a=new Apple();
		a.info();
		
		Fruit f= a.getSuper();
		System.out.println(a == f);
		System.out.println(a.color);
		System.out.println(f.color);
//		a.info();
//		f.info();
		a.AccessSuperInfo();
		
		String s1 = "java good";
		String s2 = "java"+" good";
		final String s3; 
		final String s4 = " good";

		{
			s3 = "java";
		}
		String s5 = s3+s4;
		System.out.println(s1==s5);
	}
}
