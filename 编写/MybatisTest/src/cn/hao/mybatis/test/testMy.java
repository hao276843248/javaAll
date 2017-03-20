package cn.hao.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import cn.hao.mybatis.entity.Student;
import cn.hao.mybatis.entity.TJ;
import cn.hao.mybatis.util.Mybatis;

public class testMy {
	@Test
	public void getstudent(){
		Student s=new Student();
		SqlSession session=null;
		TJ tj=new TJ("уе", 0, 0, 1, 0);
		try {
			session=Mybatis.openSession();
			s=session.selectOne("stu.select",tj);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getSex());
	}
}
