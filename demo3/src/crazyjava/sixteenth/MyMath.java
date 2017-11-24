package crazyjava.sixteenth;

public class MyMath {

	//		求ax+b=0的根
	public double oneEquation(double a, double b){
		if(a == 0){
			System.out.println("参数错误");
			throw new ArithmeticException("参数错误");
		}
		else
			return -b/a;
	}
	
	public double [] twoEquation(double a,double b,double c){
		double result[];
		if(a == 0){
			throw new ArithmeticException("参数错误");
		}else if(b*b-4*a*c < 0){
			throw new ArithmeticException();
		}else if(b*b-4*a*c == 0 ){
			System.out.println("纬一街");
			result = new double [1];
			result[0] = (-b)/(2*a);
			return result;
			
		}else{
			System.out.println("有两个届");
			result  = new double[2];
			result[0] = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
			result[1] = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
			return result;
		}
	}
}
