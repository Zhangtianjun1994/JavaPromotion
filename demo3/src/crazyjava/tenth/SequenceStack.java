package crazyjava.tenth;

import java.util.Arrays;

public class SequenceStack<T> {

	private int default_size = 10;
	private int capacity;
	private int capacityIncrement = 0;
	private Object[] elementData;
	private int size =0;
	
	public SequenceStack(){
		this.capacity = default_size;
		elementData = new Object[capacity];
		size = 0;
	}
	
	public SequenceStack(T element){
		this();
		elementData[0] = element;
		size ++;
	}
	
	public SequenceStack(T element,int initSize){
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	
	public SequenceStack(T element,int initSize,int capacityIncrement){
		this(element,initSize);
		this.capacityIncrement = capacityIncrement;
	}
	
	public int length(){
		return size;
	}
	public void push(T element){
		ensureCapacity(size+1);
		elementData[size] = element;
		size++;
	}
	public void ensureCapacity(int mincapacity){
		if(mincapacity>capacity){
			while(capacity < mincapacity){
				if(capacityIncrement > 0){
					capacity+=capacityIncrement;
					//elementData = Arrays.copyOf(elementData, capacity);
				}
				else{
					while(capacity < mincapacity)
						capacity = capacity << 1;
				}
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	public T pop(){
		if(size == 0){
			System.out.println("stack is empty");
			return null;
		}else{
			T old = (T) elementData[size-1];
			elementData[size]= null;
			size--;
			return old;
		}
	}
	
	public T peek(){
		return (T)elementData[size-1];
	}
	
	public boolean empty(){
		return size == 0;
	}
	
	public void clear(){
		Arrays.fill(elementData, null);
		size = 0;
	}
	
	public String toString(){
		if(size == 0)
			return "[]";
		else{
			StringBuilder builder = new StringBuilder("[");
			for(int i=0;i<size;i++){
				builder.append(elementData[i]+",");
			}
			builder.delete(builder.length()-1, builder.length());
			builder.append("]");
			return builder.toString();
		}
	}
}
