package crazyjava.eighth;

public class FinallyTest {

	public static int test(){
		int count = 5;
		try{
			throw new RuntimeException("“Ï≥£");
		}
		finally{
			System.out.println("finally ±ª÷¥––");
			return count;
		}
	}
	public static void main(String[] args) {
		System.out.println(test());

	}

}
