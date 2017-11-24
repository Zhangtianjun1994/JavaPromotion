package crazyjava.FouthChapter;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

	public static void main(String[] args) {
		@SuppressWarnings({ "unchecked", "unused" })
		SoftReference<Person> persons[] = new SoftReference[100000];//��ʾ�������ã��ڶԿռ䲻�������£��ڴ���Ի���
		//Person []persons = new Person[100];
		for(int i=0;i<100;i++){
			persons[i] = new SoftReference<Person>(new Person("zhang"+i,i%10+10));
			//persons[i] = new Person("zhang"+i,i%10+10);
		}
		
		//System.out.println(persons[3]);
		System.out.println(persons[2].get());
		System.out.println(persons[4].get());
		//֪ͨϵͳ������������
		System.gc();
		System.runFinalization();
		System.out.println(persons[2].get());
		System.out.println(persons[4].get());

	}

}
