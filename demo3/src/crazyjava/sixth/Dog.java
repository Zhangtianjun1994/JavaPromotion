package crazyjava.sixth;

public class Dog implements Cloneable{

	private String name;
	private double weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Dog(String name,double weight){
		this.name  = name;
		this.weight = weight;
	}
	public Object clone(){
		Dog dog = null;
		try{
			dog = new Dog(this.getName(),this.getWeight());
		}catch(Exception e){
			e.printStackTrace();
		}
		return dog;
	}
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj.getClass() == this.getClass())
		{
			Dog dog2 = (Dog) obj;
			return (dog2.name.equals(this.name) && dog2.weight == this.weight);
			
		}
		return false;
	}
	
	public int hashCode(){
		return name.hashCode()+(int)weight;
	}
}
