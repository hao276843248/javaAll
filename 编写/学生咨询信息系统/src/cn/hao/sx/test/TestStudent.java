package cn.hao.sx.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.sx.DAO.IStuinfoDAO;
import cn.hao.sx.DAO.StudentDAOImpl;
import cn.hao.sx.entity.Student;
import cn.hao.sx.entity.StudentFind;
import cn.hao.sx.entity.TJ;
import cn.hao.sx.service.IStudentSrevice;
import cn.hao.sx.service.StudentServiceImpl;

public class TestStudent {
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private IStudentSrevice is=new StudentServiceImpl();
	@Test
	public void ADd() throws ParseException{
		Date d=sdf.parse("2013-2-1");
		Student s=new Student("王三","女",d,2,3,"130131223121",1,2,d);
		is.addStudent(s);
	}
	@Test
	public void find(){
		TJ tj=new TJ("", 0,0, 0,0);
		List<StudentFind> s=is.findStudent(tj);
		for(StudentFind a:s){
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getSex());
		}
	}
	@Test
	public void getStu(){
		int id=70;
		Student s=is.getStudent(id);
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getEid());
	}
	@Test 
	public void del(){
		int id=41;
		is.delStudent(id);
	}
	@Test 
	public void updateStudent() throws ParseException{
		Date d=sdf.parse("2013-2-1");
		Student s=new Student(63,"王三","女",d,2,3,"130131223121",1,2,d);
		is.updateStudent(s);
	}
	@Test
	public  void fin(){
		TJ tj=new TJ("王", 0,0, 0,0);
		PageParam p=new PageParam(1, 2);
		List<StudentFind> s=is.findStudent(p,tj);
		for(StudentFind ss:s){
			System.out.println(ss.getName());
			System.out.println(ss.getId());
		}
	}
}
