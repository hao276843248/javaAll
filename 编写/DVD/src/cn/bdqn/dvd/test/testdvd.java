package cn.bdqn.dvd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.dvd.MovieDVD;

public class testdvd {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		MovieDVD dvdm=(MovieDVD) ctx.getBean("dvd2");
		System.out.println(dvdm.getName());
		System.out.println(dvdm.getDirector());
		System.out.println(dvdm.getDate());
		System.out.println(dvdm.getCs());
		
	}
}
