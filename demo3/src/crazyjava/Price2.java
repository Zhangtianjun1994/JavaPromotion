package crazyjava;

public class Price2 extends Price{

	private int i = 22;
	public Price2(){
		super();
		i = 222;
	}
	public void display(){
		System.out.println(i);//i��Ȼ�Ը����iû����ȫ���ǣ������������в��ܷ��ʵ������i
	}
	
	public static void main(String args[]){
		Price2 price = new Price2();//����ʱ������Price2���������ͣ���������ʱ����ΪPrice���������ͣ�
		System.out.println(price.i);
		price.display();
	}
}
