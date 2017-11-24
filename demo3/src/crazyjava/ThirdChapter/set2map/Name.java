package crazyjava.ThirdChapter.set2map;

import java.util.HashMap;
import java.util.HashSet;

public class Name {
	private String first;
	private String last;
	
	public Name(String first,String last){
		this.first = first;
		this.last = last;
	}
	
	public boolean equals(Object o){
		if(this == o)
			return true;
		if(o.getClass() == Name.class){
			Name name = (Name)o;
			return (this.first == name.getFirst());
		}
		return false;
	}
	
	public String getFirst(){
		return first;
	}
	
	public int hashCode(){
		return first.hashCode();
	}
	
	public String toString(){
		return "["+first+","+last+"]";
	}

	public static void main(String args[]){
		HashSet<Name> set = new HashSet<Name>();
		Name n1 = new Name("abc","123");
		Name n2 = new Name("abc","456");
		set.add(n1);
		set.add(n2);
		System.out.println(set);
		
		HashMap <String ,Integer> map = new HashMap<String ,Integer>();
		map.put("zzz", 50);
		map.put("zzz", 90);
		System.out.println(map.values());
		System.out.println(map.values().getClass());
	}
}
