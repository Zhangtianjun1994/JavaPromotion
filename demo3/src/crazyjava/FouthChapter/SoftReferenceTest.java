package crazyjava.FouthChapter;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

	public static void main(String[] args) {
		@SuppressWarnings({ "unchecked", "unused" })
		SoftReference<Person> persons[] = new SoftReference[100000];//表示是软引用，在对空间不足的情况下，内存可以回收
		//Person []persons = new Person[100];
		for(int i=0;i<100;i++){
			persons[i] = new SoftReference<Person>(new Person("zhang"+i,i%10+10));
			//persons[i] = new Person("zhang"+i,i%10+10);
		}
		
		//System.out.println(persons[3]);
		System.out.println(persons[2].get());
		System.out.println(persons[4].get());
		//通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		System.out.println(persons[2].get());
		System.out.println(persons[4].get());

	}

}
