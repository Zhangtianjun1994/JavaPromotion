package crazyjava;

public class Fruit {
	static int count = 20;
	String color = "未确定的颜色";
	public Fruit getThis(){
		return this;
	}
	
	public void info(){
		System.out.println("Fruit 方法");
	}

}
