package crazyjava.ThirdChapter.set2map;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetRemove {

	public static void main(String args[]){
		HashSet<String> hash = new HashSet<String>();
		for(int i=0;i<4;i++){
			hash.add("aaa"+i);
		}
		
		for(Iterator<String> it = hash.iterator();it.hasNext();){
			String s = it.next();
			System.out.println(s);
			
			if(s.equals("aaa2")){
				hash.remove(s);
			}
		}
	}
}
