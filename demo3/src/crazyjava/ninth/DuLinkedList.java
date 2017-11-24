package crazyjava.ninth;

public class DuLinkedList<T> {
	private class Node{
		private T data;
		private Node prev;
		private Node next;
		public Node(){}
		public Node(T data,Node prev,Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node header;
	private Node tail;
	private int size;
	
	public DuLinkedList(){
		this.header = null;
		this.tail = null;
		this.size = 0;
	}
	
	public DuLinkedList(T element){
		this.header = new Node(element,null,null);
		this.tail = header;
		size++;
	}
	
	public int length(){
		return size;
	}
	
	public T get(int index){
		return getNodeByIndex(index).data;
	}
	
	public Node getNodeByIndex(int index){
		if(index<0 || index>size-1){
			throw new IndexOutOfBoundsException("数组越界");
		}
		if(index < size/2){
			Node current = header;
			for(int i=0;i<size/2&&current != null;i++,current=current.next){
				if(i == index){
					return current;
				}
			}
		}else{
			Node current = tail;
			for(int i=size-1;i>size/2 && current != null;i--,current = current.prev){
				if(i == index)
					return current;
			}
		}
		return null;
	}
	
	public int locate(T element){
		Node current = header;
		for(int i=0;i<size && current != null;i++,current = current.next){
			if(current.data == element){
				return i;
			}
		}
		return -1;
	}
	
	public void insert(T element,int index){
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException("插入数组越界");
		}
		if(header == null)
			add(element);
		else{
			if(index == 0){
				addAtHeader(element);
			}
			else{
				Node prev = getNodeByIndex(index-1);
				Node next = prev.next;
				Node newNode = new Node(element,prev,next);
				prev.next = newNode;
				next.prev = newNode;
				size ++;
			}
		}
		
	}
	
	public void add(T element){
		if(header == null){
			header = new Node(element,null,null);
			tail = header;
		}
		else{
			Node newNode = new Node(element,tail,null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addAtHeader(T element){
		header = new Node(element,null,header);
		if(tail == null)
			tail = header;
		size++;
	}
	
	public T delete(int index){
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("数组越界");
		}
		Node del = null;
		if(index == 0){
			del = header;
			header = header.next;
			header.prev = null;
		}
		else{
			Node prev = getNodeByIndex(index-1);
			del = prev.next;
			prev.next = del.next;
			if(del.next != null)
				del.next.prev = prev;
			del.prev = null;
			del.next = null;
		}
		size --;
		return del.data;
		
	}
	
	public T remove(){
		return delete(size-1);
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void clear(){
		header = null;
		tail = null;
		size = 0;
	}
	
	public String toString(){
		if(isEmpty())
			return "[]";
		else{
			StringBuilder builder = new StringBuilder("[");
			for(Node current = header;current != null;current = current.next){
				builder.append(current.data.toString()+",");
			}
			int len = builder.length();
			builder = builder.delete(len-1, len).append("]");
			return builder.toString();
		}
	}
	
	public String reverseToString(){
		if(isEmpty()){
			return "[]";
		}
		else{
			StringBuilder builder = new StringBuilder("[");
			for(Node current = header;current != null;current = current.next){
				builder.append(current.data.toString()+",");
			}
			int len = builder.length();
			builder = builder.delete(len-1, len).append("]");
			return builder.toString();
		}
	}
}
