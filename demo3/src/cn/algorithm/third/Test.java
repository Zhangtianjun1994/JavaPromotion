package cn.algorithm.third;

import java.util.ArrayList;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode node1 = new TreeNode(3,null,null);
		TreeNode node2 = new TreeNode(2,null,null);
		TreeNode node3 = new TreeNode(8,null,null);
		TreeNode node4 = new TreeNode(1,null,null);
		TreeNode node5 = new TreeNode(4,null,null);
		TreeNode node6 = new TreeNode(7,null,null);
	    list.add(node1);	
	    list.add(node2);	
	    list.add(node3);	
	    list.add(node4);	
	    list.add(node5);	
	    list.add(node6);
	    MinTree tree = new MinTree(node1,list);
	    ArrayList<TreeNode> listTree = tree.initialMinTree(list);
	    System.out.println("Ç°Ðò±éÀú");
	    tree.preOrder(tree.getRoot());
	}


}
