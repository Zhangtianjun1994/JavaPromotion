package crazyjava.fifth;

import java.util.*;

public class StringTest {

	public static void main(String args[]){
		String s1 = new String("疯狂abc");
		/*/unit5
		 * 
		 */
		/*
		String s5 = "狂";
		String s3 = "疯"+"狂";
		String s2 = new String("疯狂ax");
		String s4 = "疯狂";
		String s6 = "疯"+"狂";
		System.out.println(s1 == s2);
		System.out.println("s2==s3"+s2 == s3);
		System.out.println(s3 == s4);
		System.out.println(s4 == s6);
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		Integer i3 = 127;
		Integer i4 = 127;
		System.out.println("i1==i2"+(i1 == i2));
		System.out.println(i2 == i3);
		System.out.println(i3 == i4);
		System.out.println("----------方法的测试-------------");
		String ss = "zhang:5";
		final int len = 5;//"zhang".length();
		String sss = "zhang:"+len;
		System.out.println(ss == sss);
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s1));
		System.out.println("****************************");
		StringBuilder str = new StringBuilder("zhang");
		System.out.println("zhagn:"+System.identityHashCode(str)+str);
		str.append("xue");
		System.out.println("zhangxue"+System.identityHashCode(str)+str);
		str.append("long");
		Object obj = new Object();
		System.out.println("s1是否是String类型"+obj instanceof String);
		System.out.println(s1.compareTo(s2)+"  "+s1.equals(s2));
		
		System.out.println("***********************");
		short a=4;
		a+=9000;
		double x = 23/3;
		String s = "aaaa";
		Object objj= a+s;
		s+=a;
		
		System.out.println(objj);
		*/
		//代表一个换行符
//		System.out.println("\u0063"+"adsaf");
//		System.out.println();
//		System.out.println("adsfaf");
//		List<String> list = new ArrayList<String>();
//		Person person = new Person("zhagn",20);
//		list.add("zhagn");
//		list.add("zue");
//		list.add("long");
//		list.add(person.toString());
//		List intlist=list;
//		for(int i=0;i<intlist.size();i++){
//			Object in = intlist.get(i);
//			System.out.println(in);
//		}
//		List<Integer> list[] = new ArrayList[10];
//		
//		List<Integer> list1 = new ArrayList<Integer>();
//		list1.add(23);
//		list[0] = list1;
//		System.out.println(list[0].get(0));
//		GenericArray<String> generic[] = new GenericArray[10];
//		for(int i=0;i<10;i++)
//			generic[i] = new GenericArray();
//		for(int i=0;i<10;i++){
//			generic[i].printout();
//		}
		String str = "adsfsad.aadf.sdsdf.sfae.org";
		String str1[] = str.split("\\.");
		for(String s:str1)
			System.out.println(s);
		String strReplace = str.replace(".", "\\A");
		System.out.println(strReplace);
		String strReplaceAll = str.replaceAll("\\.", "\\x");
		System.out.println(strReplaceAll);
		System.out.println("\\a");
			
	}
}
