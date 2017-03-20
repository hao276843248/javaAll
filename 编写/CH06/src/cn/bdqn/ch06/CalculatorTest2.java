package cn.bdqn.ch06;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest2 {
	
	@Before
	public void init(){
		System.out.println("Init!");
	}
	
	@After
	public void destory(){
		System.out.println("Destory!");
	}
	
	@Test
	public void checkSum(){
		System.out.println("Check Sum!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.sum(num1,num2);
		Assert.assertEquals(15,result);
	}

	@Test
	public void checkSub(){
		System.out.println("Check Sub!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.sub(num1,num2);
		Assert.assertEquals(5,result);
	}

	@Test
	public void checkMul(){
		System.out.println("Check Mul!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.mul(num1,num2);
		Assert.assertEquals(50,result);
	}
	
	@Test
	public void checkDiv(){
		System.out.println("Check Div!");
		Calculator calc=new Calculator();
		int num1=10;
		int num2=5;
		int result=calc.div(num1,num2);
		Assert.assertEquals(2,result);
	}
	
	
	
	
	
	
	
	
	
	
}









