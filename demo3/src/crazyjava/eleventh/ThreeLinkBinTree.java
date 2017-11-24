package crazyjava.eleventh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ThreeLinkBinTree<E> {

	public static class TreeNode{
		Object data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		
		public TreeNode(){}
		public TreeNode(Object data){
			this.data = data;
		}
		public TreeNode(Object data,TreeNode left
				,TreeNode right,TreeNode parent){
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		public String toString(){
			return data.toString();
		}
	}
	
	private TreeNode root;
	public ThreeLinkBinTree(){
		this.root = new TreeNode();
	}
	
	public ThreeLinkBinTree(E data){
		this.root = new TreeNode(data);
	}
	
	public TreeNode addNode(TreeNode parent,E data,boolean isLeft){
		if(parent == null){
			throw new RuntimeException("父节点为空");
		}
		if(isLeft == true && parent.left != null){
			throw new RuntimeException("无法添加左节点");
		}
		if(isLeft == false && parent.right != null){
			throw new RuntimeException("无法添加有节点");
		}
		TreeNode newNode = new TreeNode(data);
		if(isLeft){
			parent.left = newNode;
		}
		else{
			parent.right = newNode;
		}
		newNode.parent = parent;
		return newNode;
	}
	
	public boolean empty(){
		return root.data ==null;
	}
	public TreeNode getRoot(){
		return root;
	}
	
	public E parent(TreeNode node){
		if(node == null){
			throw new RuntimeException("此节点为空");
		}
		return (E) node.parent.data;
	}
	
	public E leftChild(TreeNode parent){
		if(parent == null){
			throw new RuntimeException();
		}
		return (E)parent.left.data;
	}
	
	public int deep(){
		return deep(root);
	}
	
	private int deep(TreeNode node){
		if(node == null){
			return 0;
		}
		if(node.left == null && node.right == null)
			return 1;
		else{
			int leftdeep = deep(node.left);
			int rightdeep = deep(node.right);
			int max = leftdeep>rightdeep?leftdeep:rightdeep;
			return max+1;
		}
	}
	
	//广度优先搜索
	public List<TreeNode> breadthFirst(){
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(root == null){
			throw new RuntimeException("树为空");
		}else{
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			list.add(queue.peek());
			TreeNode p = queue.poll();
			if(p.left!=null)
				queue.offer(p.left);
			if(p.right != null)
				queue.offer(p.right);
		}
		return list;
	}
	
	//深度优先搜索
	//中序遍历---非递归实现
	public void midOrder(){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null){
			throw new RuntimeException();
		}else{
			TreeNode node = root;
			while(node != null || !stack.isEmpty()){
				while(node != null){
					stack.push(node);
					node = node.left;
				}
				if(!stack.isEmpty()){
					TreeNode tmp = stack.pop();
					System.out.println(tmp+"  ");
					node = tmp.right;
				}
			}
		}
	}
	
	//前序遍历---非递归实现
	public void preOrder(){
		if(root == null){
			throw new RuntimeException();
		}else{
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode node = root;
			while(node != null || !stack.isEmpty()){
				while(node!=null){
					System.out.print(node+"  ");
					stack.push(node);
					node = node.left;
				}
				if(!stack.isEmpty()){
					TreeNode tmp = stack.pop();
					node = tmp.right;
				}
			}
		}
	}
	//后序遍历---非递归实现
	public void posOrder(){
		Stack<TreeNode> stackNode = new Stack<TreeNode>();
		Stack<String> stackFlag = new Stack<String>();
		TreeNode node = root;
		while(node != null || !stackNode.isEmpty()){
			while(node!= null){
				stackNode.push(node);
				stackFlag.push("left");
				node =node.left;
			}
			while(!stackNode.isEmpty() && stackFlag.peek().equals("right")){
				stackFlag.pop();
				System.out.print(stackNode.pop()+"  ");
			}
			if(!stackNode.isEmpty()){
				stackFlag.pop();
				stackFlag.push("right");
				node = stackNode.peek();
				node = node.right;
			}
		}
	}
	
	
	public static void main(String args[]){
		ThreeLinkBinTree<String> three = new ThreeLinkBinTree<String>("zhang");
		TreeNode left2 = three.addNode(three.getRoot(), "xue", true);
		TreeNode right3 = three.addNode(three.getRoot(), "long", false);
		three.addNode(left2, "love", true);
		System.out.println(three.deep());
		System.out.println(three.getRoot().left.toString());
		System.out.println(three.breadthFirst());
//		three.midOrder();
//		System.out.println("前序遍历-----------------");
//		three.preOrder();
		System.out.println("后序遍历------------");
		three.posOrder();
	}
	
}
