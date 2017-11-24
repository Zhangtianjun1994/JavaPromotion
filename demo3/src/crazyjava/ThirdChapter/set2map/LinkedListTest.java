package crazyjava.ThirdChapter.set2map;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String args[]){
		LinkedList<String > linked = new LinkedList<String>();
		linked.addFirst("aaaa");
		linked.addFirst("bbbb");
		linked.addFirst("ccc");
		System.out.println(linked);
		//while(linked.)
//		String s = linked.removeFirst();
//		for(;s != null;s=linked.removeFirst()){
//			System.out.println(s);
//		}
		String s = null;
		while((s=linked.pollFirst()) != null){
			System.out.println(s);
		}
		
		System.out.println("------------------------");
		System.out.println(linked.getClass());
		System.out.println(linked.iterator().getClass());
	}
}
