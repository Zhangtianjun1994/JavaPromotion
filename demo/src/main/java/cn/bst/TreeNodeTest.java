package cn.bst;

import java.util.Iterator;

public class TreeNodeTest {
	public static void main(String args[]){
		//TreeNode<String> t1 = ne
		BST<String > bst = new BST<String>();
//		TreeNode<String> t1= bst.createTreeNode("zxl");
//		TreeNode<String> t2 = bst.createTreeNode("abc");
//		TreeNode<String> t3 = bst.createTreeNode("dbc");
//		TreeNode<String> t4 = bst.createTreeNode("lz");
		bst.insert("zxl");
		bst.insert("abc");
		bst.insert("hahah");
		bst.insert("ttt");
		bst.insert("zzz");
		bst.insert("bcd");
		System.out.println("�������");
		bst.inorder();
		System.out.println("\n�������");
		bst.postorder();
		System.out.println("\nǰ�����");
		bst.preorder();
		System.out.println(bst.getSize());
		System.out.println("ɾ����������");
		bst.delete("zxl");
		bst.preorder();
		Iterator it = bst.iterator();
		System.out.println("�����������");
		while(it.hasNext())
			System.out.print(it.next()+"  ");
	}

}
