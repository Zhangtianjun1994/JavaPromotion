package crazyjava.eleventh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortedBinTree<T extends Comparable> {

	public static class Node{
		Object data;
		Node parent;
		Node left;
		Node right;
		public Node(Object data,Node parent,Node left,Node right){
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public String toString(){
			return "[data="+data+"]";
		}
		
		public boolean equals(Object obj){
			if(this == obj)
				return true;
			if(obj.getClass() == Node.class){
				Node node = (Node)obj;
				if(node.data.equals(this.data)&&node.parent==this.parent
						&&node.left ==this.left&& node.right ==this.right)
					return true;
			}
			return false;
		}

	}
	
	private Node root;
	public SortedBinTree(){
		root = null;
	}
	
	public SortedBinTree(T o){
		root = new Node(o,null,null,null);
	}
	
	public Node getRoot(){
		return root;
	}
	
	public void add(T ele){
		if(root == null)
			root = new Node(ele,null,null,null);
		else{
			Node current = root;
			Node parent = null;
			int cmp = 0;
			do{
				parent = current;
				cmp = ele.compareTo((T) current.data);
				if(cmp > 0){
					current = current.right;
				}
				else{
					current = current.left;
				}
			}while(current!=null);
			Node newNode = new Node(ele,parent,null,null);
			if(cmp > 0){
				parent.right = newNode;
			}else{
				parent.left = newNode;
			}
		}
	}
	
	//��ýڵ�
	public Node getNode(T ele){
		Node p = root;
		while(p!= null){
			int cmp = ele.compareTo((T) p.data);
			if(cmp > 0)
				p = p.right;
			else if(cmp < 0)
				p= p.left;
			else
				return p;
		}
		return null;
	}
	
	//ɾ���ڵ�
	public void remove(T ele){
		Node target = getNode(ele);
		if(target == null){
			return ;
		}
		//��������Ϊ��
		if(target.left == null&& target.right == null){
			if(target == root){
				root = null;
			}else{
				//��ɾ���ڵ��Ǹ��ڵ����ڵ�
				if(target.parent.left == target){
					target.parent.left = null;
				}else{
					target.parent.right = null;
				}
				target.parent = null;
			}
		}else if(target.left == null && target.right != null){
			//��ɾ���ڵ��Ƿ֡����ڵ�
			if(target == root){
				root = target.right;
			}else{
				//��ɾ���ڵ��Ǹ��ڵ����ڵ�
				if(target.parent.left == target){
					target.parent.left = target.right;
					
				}else{
					target.parent.right = target.right;
				}
				target.right.parent = target.parent;
			}
		}else if(target.left != null && target.right == null){
			//��ɾ���ڵ��Ƿ֡����ڵ�
			if(target == root){
				root = target.left;
			}else{
				//��ɾ���ڵ��Ǹ��ڵ����ڵ�
				if(target.parent.left == target){
					target.parent.left = target.left;
					
				}else{
					target.parent.right = target.left;
				}
				target.left.parent = target.parent;
			}
		}else{//������������Ϊ��
			Node leftMaxNode = getLeftMax(target);
			//ɾ��leftMaxNode
			if(leftMaxNode.left != null){
				leftMaxNode.parent.right = leftMaxNode.left;
			}else{
				leftMaxNode.parent.right = null;
			}
			leftMaxNode.parent = target.parent;
			//��ɾ���ڵ��Ǹ��ڵ����ڵ�
			if(target == target.parent.left){
				target.parent.left = leftMaxNode;
			}else{
				target.parent.right = leftMaxNode;
			}

			leftMaxNode.left = target.left;
			leftMaxNode.right = target.right;
			target.parent = target.right = target.left = null;
			
		}
	}
	//�õ�ĳһ���ڵ��������е����ڵ�
	public Node getLeftMax(Node node){
		if(node.left == null)
			return null;
		else{
			Node current = node.left;
			while(current != null){
				current = current.right;
			}
			return current;
		}
	}
	
	//�����������
	public List<Node> breadthFirst(Node root){
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Node> list = new ArrayList<Node>();
		if(root != null){
			queue.offer(root);
			//root.path="";
		}
		while(!queue.isEmpty()){
			Node node = queue.poll();
			list.add(node);
			if(node.left != null){
				//node.leftChild.path=node.path+"0";
				queue.offer(node.left);
				//System.out.println("����"+node.leftChild.path);
			}
			if(node.right != null){
				//node.rightChild.path = node.path+"1";
				queue.offer(node.right);
			}
		}
		return list;
	}
}
