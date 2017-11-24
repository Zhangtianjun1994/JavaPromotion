package crazyjava;

public class Wolf extends Animal{

	private String name;
	private double weight;
	public Wolf(String name,double weight){
		this.name = name;
		this.weight = weight;
	}
	
	public String getDesc(){
		return "wolf[weight = " + weight;
	}
	
	public static void main(String args[]){
		Wolf wolf = new Wolf("aaa",10.0);
//		System.out.println(wolf.toStirng());
//		
		wolf.info();
	}
	//@Override
	protected void info(){
		System.out.println("wolf");
	}
}
