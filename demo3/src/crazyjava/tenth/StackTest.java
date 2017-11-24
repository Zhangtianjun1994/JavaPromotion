package crazyjava.tenth;

public class StackTest {

	public static void main(String[] args) {
		SequenceStack<String> stack = new SequenceStack<String>("zhang",12,10);
		stack.push("xue");
		stack.push("long");
		stack.push("love");
		
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);

	}

}
