package crazyjava.eleventh;

public class TreeTest {
	
	private class Node{
		private int i;
		private Node next;
		
		public Node(int i,Node next){
			this.i = i;
			this.next = next;
		}
		public boolean equals(Object obj){
			if(obj == this){
				return true;
			}
			if(obj instanceof Node){
				Node node = (Node)obj;
				return node.i == this.i && this.next == node.next;
			}
			return false;
		}
		public String toString(){
			return "zhang"+i;
		}
	}
	
	private Node[] nodes;
	int capacity = 20;
	public TreeTest(){
		nodes = new Node[capacity];
	}
	
	public int deep(Node node){
		if(node.next == null){
			return 1;
		}
		else{
			System.out.println("else");
			int max = 0;
			//Node ne = node.next;
			while(node.next != null){
				int tmp = deep(node.next);
				if(tmp > max){
					max = tmp;
				}
				node= node.next;
			}
			return max+1;
		}
	}
	
	public int pos(Node node){
		for(int i=0;i<nodes.length;i++){
			if(node.equals(nodes[i]))
				return i;
		}
		return -1;
	}
	
	public void add(int i){
		if(nodes[0] == null){
			nodes[0] = new Node(i,null);
			//nodes[0].next = null;
		}else{
			for(int j=0;j<capacity;j++){
				if(nodes[j] == null){
					nodes[j] = new Node(i,null);
					nodes[j-1].next = nodes[j];
					break;
				}
			}
		}
	}
	
	public void show(){
		Node root = getRoot();
		Node node = root;
		while(node != null)
		{
			System.out.print(node);
			node = node.next;
		}
	}
	public Node getRoot(){
		return nodes[0];
	}

	public static void main(String[] args) {
		TreeTest tree = new TreeTest();
		//Node 
		tree.add(0);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.show();
		System.out.println(tree.deep(tree.getRoot()));

	}

}
