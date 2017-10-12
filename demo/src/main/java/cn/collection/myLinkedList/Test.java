package cn.collection.myLinkedList;

public class Test {
	public static void main(String args[]){
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("zhagn");
		list.add("xue");
		list.add("long");
		
		System.out.println(list.get(1));
		System.out.println(list.toString());
		//System.out.println(list.head.element);
		
	}

}
