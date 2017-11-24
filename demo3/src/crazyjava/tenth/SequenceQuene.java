package crazyjava.tenth;

import java.util.Arrays;

public class SequenceQuene<T> {

	private int default_size = 10;
	private int capacity;
	private Object[] elementData;
	private int front = 0;
	private int rear = 0;
	public SequenceQuene(){
		capacity = default_size;
		elementData = new Object[capacity];
	}
	
	public int length(){
		if(empty())
			return 0;
		if(rear > front)
			return rear-front;
		else{
			return capacity-front+rear;	
		}
	}
	
	public void add(T element){
		if(rear == front && elementData[front] != null){
		    throw new IndexOutOfBoundsException("∂”¡–¬˙¡À");
		}
		elementData[rear++] = element;
		rear = rear == capacity?0:rear;
	}
	public boolean empty(){
		return rear == front && elementData[front] == null;
	}
	
	public T remove(){
		if(empty()){
			throw new IndexOutOfBoundsException("quene is empty");
		}
		T old = (T) elementData[front];
		elementData[front] = null;
		front = front == capacity?0:front;
		front ++;
		return old;
	}
	
	public T element(){
		
		if(empty())
			throw new IndexOutOfBoundsException("quene is empty");
		return (T)elementData[front];
	}
	
	public void clear(){
		Arrays.fill(elementData, null);
		front = rear = 0;
	}
	
	public String toString(){
		if(front == rear)
			return "[]";
		else{
			StringBuilder builder = new StringBuilder("[");
			for(int i=front;i<rear;i++){
				builder.append(elementData[i]+",");
			}
			builder.delete(builder.length()-1, builder.length());
			builder.append("]");
			return builder.toString();
		}
	}
}
