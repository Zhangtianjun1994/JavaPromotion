package crazyjava.sixth;

public class InnerStaticClass {

	private int number;
	private static String name;
	public static void main(String args[]) throws Exception{
		InnerStaticClass sta = new InnerStaticClass();
		sta.test();
		System.out.println(sta.returnsub());
		//Inner in = new Inner();
		
	}
	
	public static  class InnerStatic{
		public void info(){
			//System.out.println(number);
			System.out.println(name);
		}
	}
	
	public Inner test() throws Exception{
		System.out.println(new Inner("zhang"));
		//System.out.println(Inner.class.newInstance());
		Inner in = new Inner();//Ĭ�ϴ����ⲿ��Ϊ�ڲ�����β�
		return in;
	}
	
	public sub returnsub(){
		sub su = new sub();
		return su;
	}
	
	public class Inner{
		
		//private  int number;
		public Inner(){
			System.out.println("Inner����͹�����");
		}
		public Inner(String name){
			System.out.println("Inner����ݹ�������name��"+name);
		}
		
		public String toString(){
			return "Inner����";
		}
	}
	public class sub extends Inner{
		public String toString(){
			return "sub extends Inner";
		}
	}
}
