package cn.algorithm.third;

import java.util.ArrayList;

public class MinTree {
	
	//成员变量
	private TreeNode root = null;
	private ArrayList<TreeNode> list = null;
	
	//构造函数
	public MinTree(){
		
	}
	public MinTree(TreeNode root,ArrayList<TreeNode> list){
		this.root = root;
		this.list = list;
	}
	
	
	public ArrayList<TreeNode> initialMinTree(ArrayList<TreeNode> list){
		
		
		//ArrayList<TreeNode> listReturn = new ArrayList<TreeNode>();
		for(int i=(list.size()-1)/2;i>=0;i--){
			min_Tree(list, i);
		}
		
		for(int i=0;i<list.size();i++){
			if(2*i+1 < list.size())
				list.get(i).leftChild = list.get(2*i+1);
			if(2*i+2 < list.size())
				list.get(i).rightChild = list.get(2*i+2);
		}
		root = list.get(0);
		return list;
	}
	
	//构建最小堆
	public void min_Tree(ArrayList<TreeNode> list,int i){
		int left = 2*i+1;
		int right = 2*i+2;
		int minIndex = -1;
		//先判断左孩子
		if(left < list.size()){
			if(list.get(left).getValue() < list.get(i).getValue())
				minIndex = left;
			else
				minIndex = i;
		}
		
		if(right < list.size()){
			if( list.get(right).getValue() < list.get(minIndex).getValue())
			minIndex = right;
		}
		
		if(minIndex != i && minIndex != -1){
			TreeNode minValue = list.get(minIndex);
			list.set(minIndex, list.get(i));
			list.set(i, minValue);
			min_Tree(list, minIndex);
		}

	}
	
	public void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.getValue()+"  ");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}
	
	//得到根节点
	public TreeNode getRoot(){
		return root;
	}
	


}
