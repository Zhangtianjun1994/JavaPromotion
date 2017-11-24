package crazyjava.eleventh.redblack;

public class RedBlackTreeTest {

	public static void main(String[] args) {
		RedBlackTree<Integer > redblack = new RedBlackTree<Integer>();
		redblack.add(13);
		redblack.add(9);
		redblack.add(18);
		redblack.add(5);
		redblack.add(10);
		redblack.add(16);
		redblack.add(25);
		redblack.add(8);
		redblack.add(23);
		redblack.add(30);
		//System.out.println(redblack.breadthFirst(redblack.getRoot()));
		redblack.remove(25);
		System.out.println(redblack.breadthFirst(redblack.getRoot()));
	}

}
