package crazyjava.sixteenth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class HelloTest {

	@Test
	public void sayHelloTest(){
		Hello hello = new Hello();
		assertEquals("hello", hello.sayHello());
	}
	
//	public static void main(String args[]){
//		JUnitCore.main("crazyjava.sixteenth.HelloTest");
//	}
}
