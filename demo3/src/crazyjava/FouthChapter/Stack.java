package crazyjava.FouthChapter;

import javax.management.RuntimeErrorException;

public class Stack {

	private Object[]elementData;
	private int size;
	private int capacityIncrement;
	
	public Stack(int initialCapacity){
		elementData = new Object[initialCapacity];
	}
	
	public Stack(int initialCapacity ,int capacityIncrement){
		this.capacityIncrement = capacityIncrement;
		elementData = new Object[initialCapacity];
	}
	
	public void push(Object obj){
		ensureCapatcity();
		elementData[size++] = obj;
	}
	
	public Object pop(){
		if(size == 0){
			throw new RuntimeException("the stack is empty");
			
		}
		Object obj = elementData[--size];
		elementData[size] = null;
		return obj;
	}
	public int size(){
		return size;
	}
	
	private void ensureCapatcity(){
		if(size == elementData.length){
			Object oldElement[] = elementData;
			int newLength = 0;
			if(capacityIncrement > 0){
				newLength = elementData.length + capacityIncrement;
			}
			else{
				newLength = (int)(elementData.length* 1.5) ;
			}
			elementData = new Object[newLength];
			System.arraycopy(oldElement, 0, elementData, 0, size);
		}
	}
	
	public static void main(String args[]){
		Stack stack = new Stack(10);
		for(int i=0;i<10;i++){
			stack.push("name"+i);
		}
		for(int i=0;i<10;i++){
			System.out.println(stack.pop());
		}
	}
}
