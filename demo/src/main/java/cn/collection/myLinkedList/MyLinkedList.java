package cn.collection.myLinkedList;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E>{
	 Node<E> head = null;
	private Node<E> tail = null;
	
	
	public MyLinkedList() {
		
	}
	
	public MyLinkedList(E []objects){
		for(int i=0;i<objects.length;i++)
			add(objects[i]);
	}
	
	@Override
	public void add(int index, E e) {
	
		if(index == 0)
			addFirst(e);
		else if(index >= size)
			addLast(e);
		else{
			Node<E> currentNode = head;
			for(int i=1;i<index;i++)
				currentNode = currentNode.next;
			Node<E> tmp = currentNode.next;
			currentNode.next = new Node<E>(e);
			(currentNode.next).next = tmp;
			
		}
		size++;
	}
	
	public void addFirst(E e){
		Node<E> newNode = new Node(e);
		Node<E> tmp = head;
		head = newNode;
		head.next = tmp;
		size++;
		
		if(tail == null)
			tail = head;
	}
	
	public void addLast(E e) {
		// TODO Auto-generated method stub
		Node<E> newNode = new Node(e);
		if(tail == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		//data = (E[])new Object[INITIAL_CAPACITY];
		head = tail = null;
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		Node<E> current = head;
		int currentIndex = 0;
		while(current != null){
			if(e != get(currentIndex)){
				currentIndex++;
				current = current.next;
			}
			if(e == get(currentIndex))
				break;
		}
		if(current == null)
			return false;
		else 
			return true;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> currentNode = head;
		for(int i=1;i<index;i++)
			currentNode = currentNode.next;
		return currentNode.element;
		
	}

	private void checkIndex(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
	}
	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		Node<E> current = head;
		for(int i=0;i<size;i++){		
			if(current.element.equals(e)){	
				return i;
			}else{
				current = current.next;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		int last = -1;
		Node<E> current = head;
		for(int i=0;i<size;i++){
			if(current.element.equals(e))
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
		Node<E> current = head;
		for(int i=1;i<index;i++)
			current= current.next;
		Node<E> removeNode = current.next;
		E tmp = current.element;
		current.next = removeNode;
		size--;
		return tmp;
	}

	@Override
	public Object set(int index, E e) {
return null;
	}

	public String toString(){
		Node<E> current = head;
		StringBuilder builder = new StringBuilder("[");
		while(current!=null){
			builder.append(current.element);
			current = current.next;
			if(current!= null)
			builder.append(",");
		}
		builder.append("]");
		return builder.toString();
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
			//for(int )
			Node<E> currentNode = head;
	return currentNode.element;
		
	}
	}
}
