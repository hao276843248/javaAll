package cn.hao.reserve.test;

import java.sql.Timestamp;
import java.util.List;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hao.reserve.entity.Room;
import cn.hao.reserve.service.IReserveService;
import cn.hao.reserve.util.PageBean;

public class Test1 {

	@Test
	public void find(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		IReserveService ir=(IReserveService) ctx.getBean("reserveService");
		PageBean p=ir.findReserve(1, 5, new Timestamp(System.currentTimeMillis()), 5, 18, 1);
		List<Object[]> o=p.getResults();
		System.out.println(o.size());
		for(Object[] a:o){
			Room room=(Room) a[0];
			System.out.println(room.getName());
		}
		
	}
	
}
