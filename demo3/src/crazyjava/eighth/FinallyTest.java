package crazyjava.eighth;

public class FinallyTest {

	public static int test(){
		int count = 5;
		try{
			throw new RuntimeException("�쳣");
		}
		finally{
			System.out.println("finally ��ִ��");
			return count;
		}
	}
	public static void main(String[] args) {
		System.out.println(test());

	}

}
