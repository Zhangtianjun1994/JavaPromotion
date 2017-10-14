package cn.bst;

public interface Tree<E> extends Iterable<E> {//实现iterator（）方法
	public boolean search(E e);
	
	public boolean insert (E e);
	
	public boolean delete(E e);
	
	public void inorder();
	
	public void postorder();
	
	public void preorder();
	
	public int getSize();
	
	public boolean isEmpty();

}
