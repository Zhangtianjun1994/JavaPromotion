package crazyjava.ninth;

public class Test {

	public static void main(String[] args) {
		DuLinkedList<String> linked = new DuLinkedList<String>();
		for(int i=0;i<10;i++){
			linked.add("zhang"+i);
		}
		System.out.println(linked.toString());
		linked.insert("xuelong", 2);
		linked.delete(3);
		System.out.println(linked.toString());

	}

}
