package crazyjava.FouthChapter;

import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args) throws InterruptedException {
		WeakHashMap<Person,String> map = new WeakHashMap<Person,String>();
		for(int i=0;i<10;i++){
			map.put(new Person("zzz"+i,i*10), "value"+(i+11));
			
		}
		System.out.println(map);
		Person person = new Person("zzz2",20);
		System.out.println(map.get(person));
		
		System.gc();
		Thread.sleep(50);
		System.out.println(map);
		System.out.println(map.get(person));

	}

}
