package cn.algorithm.third;

public class TreeNode implements Comparable{

	private int value;
	 TreeNode leftChild;
	 TreeNode rightChild;
	
	public TreeNode(int value,TreeNode leftChild,TreeNode rightChild){
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public int compareTo(Object  node) {
		// TODO Auto-generated method stub
		TreeNode node1= (TreeNode)node;
		if(this.value>node1.value)
			return 1;
		else if(this.value < node1.value)
			return -1;
		else
			return 0;
	}
	public int getValue(){
		return value;
	}
}
