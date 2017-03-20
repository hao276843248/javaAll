package cn.bdqn.reserve.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.reserve.dao.IReserveDAO;
import cn.bdqn.reserve.util.PageBean;

public class ReserveDAOTest {

	@Test
	public void testFindReserve(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		IReserveDAO reserveDAO=(IReserveDAO)ctx.getBean("reserveDAO");
		
		PageBean p=reserveDAO.findReserve(1,5,(Timestamp) new Date(),8,17,1);
		
		System.out.println(p.getResults());
		
	}
	
	
}
