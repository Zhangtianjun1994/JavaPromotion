package crazyjava.sixteenth;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class JUnitTest {

	//需要测试的类生命为本类的成员变量
	MyMath mymath;
	
	@Before
	public void setUp(){
		mymath = new MyMath();
	}
	
	@After
	public void tearDown(){
		mymath = null;
	}
	
	@Test(expected=ArithmeticException.class)
	public void testOneEquation(){
		System.out.println("test :");
		assertEquals(mymath.oneEquation(5, -9),1.8,.01);
		assertEquals(mymath.oneEquation(0, 9),-1,0.00001);
	}
	
	@Test
	public void testTwoEquation(){
		System.out.println("test 2:");
		double tmp[] = mymath.twoEquation(1, -3, 2);
		
		//assertEquals(tmp[0],2,.01);
	}
	
//	public static void main(String args[]){
//		//运行单个测试用例
//		JUnitCore.main("JUnitTest");
//	}
}
