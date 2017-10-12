package cn.zxl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("enter:");
		int n = input.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		final int NUB = 10;
		int count = 0;
		int number = 2;
		int root = 1;
		while(number <= n){
			boolean isPrime = true;
			if(number > root * root)
				root++;
			for(int k=0;k<list.size() && k <= root;k++){
				if(number % list.get(k) == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime == true){
				list.add(number);
			count ++;
			if(count % NUB == 0)
				System.out.print(number+"\n");
			else
				System.out.print(number+"  ");
		}	
		number++;

		}
	}
	
//	public static void main(String args[]){
//		Scanner input = new Scanner(System.in);
//		System.out.println("enter:");
//		int n = input.nextInt();
//		final int NUB = 10;
//		int count = 0;
//		int number = 2;
//		while(number <= n){
//			boolean isPrime = true;
//			int root = (int)(Math.sqrt(number));
//			for(int divsor = 2;divsor <= root;divsor++){
//				if(number % divsor == 0){
//					isPrime = false;
//					break;
//				}
//			}
//			if(isPrime == true){
//				count ++;
//				if(count % NUB == 0)
//					System.out.print(number+"\n");
//				else
//					System.out.print(number+"  ");
//			}	
//			number++;
//	}
//	}
//	public static int GCD(int m,int n){
//		if(m<n){
//			int test = 0;
//			test = n;
//			n = m;
//			m = test;
//		}
//		int gcd = 1;
//		if(m % n == 0) gcd = n;
//		
//		for(int i = n/2;i >= 1;i--){
//			if(m % i == 0 && n % i == 0){
//				gcd = i;
//				break;
//			}
//				
//		}
//		return gcd;
//		
//	}
//	
//	public static void main(String args[]){
//		Scanner input = new Scanner(System.in);
//		System.out.println("the num1: ");
//		int n1 = input.nextInt();
//		System.out.println("the num2: ");
//		int n2 = input.nextInt();
//		int result = GCD(n1,n2);
//		System.out.println("the result:"+result);
//	}
//	
//	public static void main(String args[]){
//		
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("enter the number:");
//		int num = input.nextInt();
//		int result = fib(num);
//		System.out.println("the result is :"+result);

//		String text = "Good morning. have a good class. have a good visit. have fun.";
//		Map<String,Integer> treeMap = new TreeMap<String,Integer>();
//		String []word = text.split("[ \n\t\r.,;!?(){}]");
//		if(word.length > 0){
//			for(int i=0;i<word.length;i++){
//				if(treeMap.containsKey(word[i])){
//					int value = treeMap.get(word[i]);
//					value++;
//					treeMap.put(word[i], value);
//				}
//				else
//					treeMap.put(word[i], 1);
//			}
//		}
//		
//		System.out.println(treeMap);
//	}
//	
//	public static int fib(int n){
//		int f0 = 0;
//		int f1 = 1;
//		int f2 = 2;
//		for(int i=3;i<n;i++){
//			f0 = f1;
//			f1 = f2;
//			f2 = f0 + f1;
//		}
//		
//		return f2;
//		
//	}

}
