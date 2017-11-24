package crazyjava.ThirdChapter;

import java.util.Arrays;

public class CommandTest{

	public  int [] process(IntArrayproducter produce,int length){
		int array[] = new int[length];
		for(int i=0;i<length;i++){
			array[i] = produce.product();
		}
		return array;
	}
	

//	private class IntArrayproducterImpl implements IntArrayproducter{
//		
//		public IntArrayproducterImpl(){
//			
//		}
//		public int product(){
//			return (int)Math.random()*seed;
//		}
//	}
//	
//	public int [] prduce(){
//		return process(new IntArrayproducterImpl(),10);
//	}

	public static void main(String args[]){
		//int seed = 10000;	
		final int seed = 10000;
		CommandTest command = new CommandTest();
//		int arr[] = command.process(new IntArrayproducter() {
//			
//			@Override
//			public int product() {
//				// TODO Auto-generated method stub
//				return (int)Math.round(Math.random()*seed);
//			}
//		}, 10);
		
		class IntArrayproducterImpl implements IntArrayproducter{

		public int product(){
			return (int)(Math.random()*seed);
		}
	}
		int arr[] = command.process(new IntArrayproducterImpl(),10);
		System.out.println(Arrays.toString(arr));
				
	}
}
