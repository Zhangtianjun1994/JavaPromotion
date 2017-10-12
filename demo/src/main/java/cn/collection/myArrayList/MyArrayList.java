package cn.collection.myArrayList;

import java.util.Iterator;

import com.sun.glass.ui.View.Capability;

import cn.collection.myLinkedList.MyAbstractList;

public class MyArrayList<E> extends MyAbstractList<E>{

	public static final int INITIAL_CAPACITY = 16;
	private E[] data = (E[]) new Object[INITIAL_CAPACITY];
	
	public MyArrayList(){}
	
	public MyArrayList(E []objects){
		for(int i=0;i<objects.length;i++)
			add(objects[i]);
	}
	
	@Override
	public void add(int index, E e) {
		// TODO Auto-generated method stub
		enSureCapacity();
		if(index<0 || index>size)
			System.out.println("can not input the number because of the outbound!!!");
		else{
			for(int i=size-1;i>=index;i++){
				data[i+1] = data[i];
			}
			data[index] = e;
			size++;
		}
	}
	
	private void enSureCapacity(){
		if(size >= data.length){
			E []newData = (E[]) new Object[size * 2+1];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data = (E[])new Object[INITIAL_CAPACITY];
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		if(indexOf(e) >= 0)
			return true;
		else
			return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
	}
	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		for(int i=0;i<size;i++){
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		int last = -1;
		for(int i=0;i<size;i++){
			if(data[i].equals(e))
				last = i;
		}
		if(last == -1)
			return -1;
		else
			return last;
		//return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		E tmp = data[index];
		for(int i=index;i<size-1;i++){
			data[i] = data[i+1];
		}
		size--;
		return tmp;
	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		checkIndex(index);
		E old = data[index];
		data[index] = e;
		return old;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder("[");
		for(int i=0;i<size;i++){
			builder.append(data[i]);
			if(i<size-1)
			builder.append(",");
		}
		builder.append("]");
		return builder.toString();
	}
	
	public void trimToSize(){
		if(size != data.length){
			E []newData = (E[]) new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterater();
	}
	
	private class ArrayListIterater implements Iterator<E>{//Iterator½Ó¿Ú
		private int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (current<size);
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return data[current++];
		}
		
	}

}
