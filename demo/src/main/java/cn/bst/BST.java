package cn.bst;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> extends AbstractTree<E>{

	protected TreeNode<E> root;
	protected int size = 0;
	
	public BST(){}
	
	public BST(E []objects){
		for(int i=0;i<objects.length;i++){
			insert(objects[i]);
		}
	}
	
	@Override
	public boolean search(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> currentNode = root;
		while(currentNode != null){
			if(e.compareTo(currentNode.element) > 0)
				currentNode = currentNode.right;
			else if(e.compareTo(currentNode.element) < 0)
				currentNode = currentNode.left;
			else
				return true;
		}
		
		if(currentNode == null)
			return false;
		else
			return true;
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		if(root == null)
			root = createTreeNode(e);
		else{
			TreeNode<E> parentNode = null;
			TreeNode<E> currentNode = root;
			while(currentNode != null)
			if(currentNode.element.compareTo(e) > 0){
				parentNode = currentNode;
				currentNode = currentNode.left;
			}else if(currentNode.element.compareTo(e) < 0){
				parentNode = currentNode;
				currentNode = currentNode.right;
			}else//重复的元素不能插入
				return false;
			
			if(e.compareTo(parentNode.element) > 0){
				parentNode.right = createTreeNode(e);
			}
			if(e.compareTo(parentNode.element) < 0)
				parentNode.left = createTreeNode(e);
			
		}
		
		size++;
		return true;
	}

	public TreeNode<E> createTreeNode(E e){
		return new TreeNode<E>(e);
	}
	
	@Override
	public void inorder(){
		inorder(root);
	}
	
	public void inorder(TreeNode<E> root){
		if(root == null) return ;
		inorder(root.left);
		System.out.print(root.element+ "  ");
		inorder(root.right);
	}
	
	@Override
	public void postorder(){
		postorder(root);
	}
	
	public void postorder(TreeNode<E> root){
		if(root == null)return ;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element+"  ");
	}
	
	@Override
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(TreeNode<E> root){
		if(root == null) return ;
		System.out.print(root.element+"  ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public TreeNode<E> getRoot(){
		return root;
	}
	
	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> currentNode = root;
		TreeNode<E> parentNode = null;
		while(currentNode != null){
			if(e.compareTo(currentNode.element) > 0){
				parentNode = currentNode;
				currentNode = currentNode.right;
			}
				
			else if(e.compareTo(currentNode.element) < 0){
				parentNode = currentNode;
				currentNode = currentNode.left;
			}
				
			else
				break;
		}
		
		if(currentNode == null)
			return false;
		
		if(currentNode.left == null && currentNode.right == null){//第一种情况，删除的是叶子结点
			if(parentNode == null)
				root = null;
			else if(parentNode.left == currentNode){
				parentNode.left = null;
				//currentNode = null;
			}else{
				parentNode.right = null;
			}
		}
		
		//第二种\三种情况,
		if(currentNode.left != null || currentNode.right != null){
			//第三种情况，有两个节点
			if(currentNode.left != null&& currentNode.right !=null){
				//有两个节点的情况进行删除
				TreeNode<E> parentOfMost = currentNode;
				TreeNode<E> leftMost = parentOfMost.left;
				while(leftMost.right != null){
					parentOfMost = leftMost;
					leftMost = leftMost.right;
				}
				currentNode.element = leftMost.element;
				
				if(parentOfMost.right == leftMost)
					parentOfMost.right = leftMost.left;
				else
					parentOfMost.left = leftMost.left;
				
			}
			else{//第二种情况，只有一个节点
				if(currentNode.left == null){
					if(parentNode == null)
						root = parentNode.right;
					else if(parentNode.left == currentNode){
						parentNode.left = currentNode.right;
					}
					else{
						parentNode.right = currentNode.right;
					}
				}
				else{//只有左节点
					if(parentNode == null)
						root = parentNode.left;
					else if(parentNode.left == currentNode){
						parentNode.left = currentNode.left;
					}
					else{
						parentNode.right = currentNode.left;
					}
					
				}
			}
		}
		size--;
		//返回true
		return true;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	//return a path from the root to the specified element
	public ArrayList<E> path(E e){
		ArrayList<E> list = new ArrayList<E>();
		TreeNode<E> currentNode = root;
		while(currentNode != null){
			list.add(currentNode.element);
			if(e.compareTo(currentNode.element) < 0)
				currentNode = currentNode.left;
			else if(e.compareTo(currentNode.element) > 0)
				currentNode = currentNode.right;
			else
				break;
		}
		
		return list;
		
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new InorderIterator<E>();
	}

	public class InorderIterator<E> implements Iterator<E>{

		private int current = 0;
		ArrayList<E> list = new ArrayList<E>();
		public InorderIterator() {
			inorder((TreeNode<E>) root);
		}
		
		private void inorder(TreeNode<E> root){
			if(root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return current<list.size();
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return list.get(current++);
		}
		
	}
}
