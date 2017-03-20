package cn.bdqn.ch06;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase{
	
	@Override
	protected void setUp() throws Exception {
		System.out.println("Set UP!");	
	}
	
	@Override
	protected void tearDown() throws Exception {
		System.out.println("Tear Down!");
	}
	
	
	public void testSum(){
		System.out.println("Test Sum!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.sum(num1, num2);
		
		Assert.assertEquals(15, result);
	}
	
	
	public void testSub(){
		System.out.println("Test Sub!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.sub(num1, num2);
		
		Assert.assertEquals(5, result);
	}
	
	
	public void testMul(){
		System.out.println("Test Mul!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.mul(num1, num2);
		
		Assert.assertEquals(50, result);
	}
	
	
	public void testDiv(){
		System.out.println("Test Div!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.div(num1, num2);
		
		Assert.assertEquals(2, result);
	}
	
	
	
	
	

}
