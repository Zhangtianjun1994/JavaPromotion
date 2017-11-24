package crazyjava.eleventh;


public class SortedBinTreeTest {

	public static void main(String[] args) {
		SortedBinTree<Integer> tree = new SortedBinTree<Integer>();
		System.out.println("adfasdfasdfa");
		tree.add(12);
		tree.add(30);
		tree.add(40);
		tree.add(14);
		//tree.add("bb");
		tree.add(23);
		tree.add(26);
		System.out.println(tree.breadthFirst(tree.getRoot()));

	}

}
