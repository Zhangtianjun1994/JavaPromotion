package crazyjava.sixth;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Wolf implements Serializable{
	
	public static void info(){
		System.out.println("static info()");
	}
//
//	private static Wolf instance;
//	private String name;
//	
//	public void setName(String name){
//		this.name = name;
//	}
//	
//	public String getName(){
//		return name;
//	}
//	public Wolf(String name){
//		this.name = name;
//		//instance = this;
//	}
//	
//	public static Wolf getInstance(String name){
//		if(instance == null)
//			instance = new Wolf(name);
//		return instance;
//	}
//	
//	private Object readResolve() throws ObjectStreamException{
//		return instance;
//	}
//	
////	public boolean equals(Object obj){
////		if(this == obj)
////			return true;
////		if(this.getClass() == obj.getClass()){
////			Wolf object= (Wolf) obj;
////			return this.name.equals(object.getName());
////		}
////		return false;
////	}
//	
//	public int hashCode(){
//		return name.hashCode();
//	}
}
