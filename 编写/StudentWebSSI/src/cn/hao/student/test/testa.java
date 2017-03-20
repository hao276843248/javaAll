package cn.hao.student.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bdqn.mybatis.plugin.PageParam;

import cn.hao.student.entity.Student;
import cn.hao.student.mapper.StudentMapper;
import cn.hao.student.service.student.IStudentService;

public class testa {

	public static void main(String[] args) {
		ApplicationContext a=new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService iStudentService= (IStudentService) a.getBean("studentService");
		StudentMapper studentMapper=(StudentMapper) a.getBean(StudentMapper.class);
		PageParam p=new PageParam(1,2);
		List<Student> result=studentMapper.findStudent(p, null);
		System.out.println(result.size());
	}
}
