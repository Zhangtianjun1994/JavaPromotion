package crazyjava.sixteenth;

public class MyMath {

	//		��ax+b=0�ĸ�
	public double oneEquation(double a, double b){
		if(a == 0){
			System.out.println("��������");
			throw new ArithmeticException("��������");
		}
		else
			return -b/a;
	}
	
	public double [] twoEquation(double a,double b,double c){
		double result[];
		if(a == 0){
			throw new ArithmeticException("��������");
		}else if(b*b-4*a*c < 0){
			throw new ArithmeticException();
		}else if(b*b-4*a*c == 0 ){
			System.out.println("γһ��");
			result = new double [1];
			result[0] = (-b)/(2*a);
			return result;
			
		}else{
			System.out.println("��������");
			result  = new double[2];
			result[0] = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
			result[1] = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
			return result;
		}
	}
}
