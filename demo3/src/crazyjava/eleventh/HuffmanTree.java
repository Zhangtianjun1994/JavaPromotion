package crazyjava.eleventh;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HuffmanTree {

	public static class Node<E>{
		E data;
		double weight;
		Node leftChild;
		Node rightChild;
		String path;
		public Node(E data,double weight){
			this.data = data;
			this.weight = weight;
		}
		public String toString(){
			return "Node["+data+",weight="+weight+"]";
		}
	}
	
	private static Node createTree(List<Node> nodes){
		while(nodes.size() > 1){
			quickSort(nodes);
			//System.out.println(nodes);
			Node left = nodes.get(nodes.size()-1);
			Node right = nodes.get(nodes.size()-2);
			//System.out.println("left:"+left+"  right:"+right);
			Node parent = new Node(null,left.weight+right.weight);
			parent.leftChild = left;
			parent.rightChild = right;
			
			nodes.remove(nodes.get(nodes.size()-1));
			nodes.remove(nodes.size()-1);
			
			nodes.add(parent);
		}
		return nodes.get(0);//返回根节点
	}
	
	private static void swap(List<Node> nodes,int i,int j){
		Node tmp;
		tmp = nodes.get(i);
		nodes.set(i, nodes.get(j));
		nodes.set(j, tmp);
	}
	//快速排序的思想
	private static void subSort(List<Node> nodes,int start,int end){
		if(start < end){
			Node base = nodes.get(start);
			int i = start;
			int j = end + 1;
			while(true){
				while(i<end && nodes.get(++i).weight >= base.weight);
				while(j>start && nodes.get(--j).weight <= base.weight);
				//System.out.println("i:"+nodes.get(i)+"  j:"+nodes.get(j));
				if(i < j){
					swap(nodes,i,j);
				}else{
					break;
				}
			}
			swap(nodes,start,j);
			subSort(nodes, start, j-1);
			subSort(nodes,j+1,end);
		}
	}
	
	public static void quickSort(List<Node> nodes){
		subSort(nodes,0,nodes.size()-1);
	}
	
	public static List<Node> breadthFirst(Node root){
		Queue<Node> queue = new ArrayDeque<Node>();
		List<Node> list = new ArrayList<Node>();
		if(root != null){
			queue.offer(root);
			root.path="";
		}
		while(!queue.isEmpty()){
			Node node = queue.poll();
			list.add(node);
			if(node.leftChild != null){
				node.leftChild.path=node.path+"0";
				queue.offer(node.leftChild);
				System.out.println("测试"+node.leftChild.path);
			}
			if(node.rightChild != null){
				node.rightChild.path = node.path+"1";
				queue.offer(node.rightChild);
			}
		}
		return list;
	}
	public static void main(String args[]){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("A",40.0));
		nodes.add(new Node("B",8.0));
		nodes.add(new Node("C",10.0));
		nodes.add(new Node("D",30.0));
		nodes.add(new Node("E",20.0));
		nodes.add(new Node("F",15.0));
		Node root = HuffmanTree.createTree(nodes);
		System.out.println(HuffmanTree.breadthFirst(root));
		List<Node> list = HuffmanTree.breadthFirst(root);
		for(int i=0;i<list.size();i++){
			System.out.print(i+":"+list.get(i).path+"  ");
		}
	}
}
