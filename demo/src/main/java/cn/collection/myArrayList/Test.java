package cn.collection.myArrayList;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<String> list = new MyArrayList<>();
		list.add("zhagnxuelong");
		list.add("luzhen");
		list.add("lichao");
		list.add("zhangbin");
		
		
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+"  ");
		}
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
