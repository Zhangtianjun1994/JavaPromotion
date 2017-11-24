package cn.algorithm.third;



public class InorderMinTree {

	private TreeNode root;
	TreeNode []copy = null;
	
	public void initial(TreeNode []nodes){
		copy = new TreeNode[nodes.length+1];
	}
	
	public void inOrder_minTree(TreeNode[]nodes,int l,int r,int index){
		
		if(r >= l && index<copy.length){
			int minIndex = min_index(nodes,l,r);
			copy[index] = nodes[minIndex];
			//System.out.println("111111");
			
			//if(index*2+1<=copy.length){
				inOrder_minTree(nodes, l, minIndex-1, 2*index+1);
				System.out.println("index"+index);
			//}

			//if(index*2+2 <= copy.length){
				inOrder_minTree(nodes, minIndex+1, r, 2*index+2);
				System.out.println("index2"+index);
			//}
		}
		

		
		
	}

	
	public int min_index(TreeNode[]nodes,int l,int r){
		int minIndex = l;
		int minValue = nodes[l].getValue();
		for(int i=1+l;i<=r;i++){
			if(nodes[i].getValue() < minValue){
				minValue = nodes[i].getValue();
				minIndex = i;
			}
		}
		return minIndex;//得到一个数组的最小元素的小标
	}
	

	public void preOrder(TreeNode root){
		if(root != null){
			System.out.print(root.getValue()+"  ");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}
	public void show(){
		System.out.println(copy[5]);
//		for(int i=0;i<copy.length;i++){
//
//			System.out.print(copy[i].getValue()+" ");
//		}
	}
	
	//构建树结构
	public void  create_heap(){
		root = copy[0];
		//TreeNode tmp = root;
		for(int i=0;i<copy.length;i++){
			if(2*i+1 < copy.length)
			copy[i].leftChild = copy[2*i+1];
			if(2*i+2 < copy.length)
			copy[i].rightChild = copy[2*i+2];
		}
	}
	
	//得到根节点
	public TreeNode getRoot(TreeNode []nodes){
		int index = min_index(nodes,0,nodes.length-1);
		return nodes[index];
	}
	
	public static void main(String args[]){
		TreeNode root = null;
		///InorderMinTree min = new InorderMinTree();
		TreeNode node1 = new TreeNode(3,null,null);
		TreeNode node2 = new TreeNode(2,null,null);
		TreeNode node3 = new TreeNode(8,null,null);
		TreeNode node4 = new TreeNode(1,null,null);
		TreeNode node5 = new TreeNode(4,null,null);
		TreeNode node6 = new TreeNode(7,null,null);
		TreeNode[] nodes = {node1,node2,node3,node4,node5,node6};
		TreeNode []copy = new TreeNode[nodes.length];
		InorderMinTree min = new InorderMinTree();

		min.initial(nodes);
		min.inOrder_minTree(nodes, 0, nodes.length-1, 0);
		min.show();
		min.create_heap();
		min.preOrder(min.getRoot(nodes));
	}
}
