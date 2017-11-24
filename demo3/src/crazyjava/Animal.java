package crazyjava;

public class Animal {

	private String desc;

	
	public String getDesc(){
		return "animal";
	}
	
	public String toStirng(){
		return getDesc();
	}
	
	private void info(){
		System.out.println("animal");
	}
}
