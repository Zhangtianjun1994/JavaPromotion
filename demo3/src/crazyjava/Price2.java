package crazyjava;

public class Price2 extends Price{

	private int i = 22;
	public Price2(){
		super();
		i = 222;
	}
	public void display(){
		System.out.println(i);//i虽然对父类的i没有完全覆盖，但是在子类中不能访问到父类的i
	}
	
	public static void main(String args[]){
		Price2 price = new Price2();//运行时类型是Price2（子类类型），而编译时类型为Price（父类类型）
		System.out.println(price.i);
		price.display();
	}
}
