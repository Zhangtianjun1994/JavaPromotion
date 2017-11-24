package crazyjava.ThirdChapter.set2map;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListRemove {
	public static void main(String args[]){
		ArrayList<String> list = new ArrayList<String >();
		for(int i=0;i<3;i++){
			list.add("aaa"+i);
		}
		
		for(Iterator<String> it = list.iterator();it.hasNext();){
			String s = it.next();
			System.out.println(s);
			
			if(s.equals("aaa2"))
				list.remove(s);
		}
		System.out.println(list);
	}
	
	

}
