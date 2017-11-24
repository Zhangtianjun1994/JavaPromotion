package crazyjava.ThirdChapter.set2map;

import java.util.EmptyStackException;
import java.util.Vector;


public class Stack<E> extends Vector<E>{

	public Stack(){}
	
	public E push(E item){
		//VectorµÄ·½·¨
		addElement(item);
		return item;
	}
	public synchronized  E pop(){
		E obj;
		int len = size();
		obj = peek();
		removeElementAt(len-1);
		return obj;
	}
	
	public synchronized  E peek(){
		int len = size();
		if(len ==0 ){
			throw new EmptyStackException();
		}
		return elementAt(len-1);
	}
	
	public boolean empty(){
		return size()==0;
	}
	
	public synchronized  int search(Object o){
		int i = lastIndexOf(o);
		if(i >= 0)
			return size()-i;
		
		return -1;
	}
	
	public static void main(String args[]){
		Stack<String> stack = new Stack<String>();
		stack.push("zzz");
		stack.push("ddd");
		stack.push("dfs");
		System.out.println(stack.pop());
		
	}
}
