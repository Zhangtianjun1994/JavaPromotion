package crazyjava;

public class Price {
	private int i = 2;
	public Price(){
		System.out.println(this.i);
		System.out.println(this.getClass());
		this.display();
	}
	public void display(){
		System.out.println(i);
	}
}
