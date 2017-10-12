package cn.collection.myLinkedList;

public class Node<E> {
	protected E element;
	protected Node<E> next;
	
	public Node(E element){
		this.element = element;
	}

}
