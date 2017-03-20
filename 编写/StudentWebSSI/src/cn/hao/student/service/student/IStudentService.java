package cn.hao.student.service.student;


import cn.hao.student.entity.Student;
import cn.hao.student.util.PageBean;

public interface IStudentService {

	public Student getStudent(int id);
	
	public PageBean findStudent(int pageIndex, int pageSize,String name);
	
	public void addStudent(Student student);
	
	public void deleteStudent(int id);
	
	public void updateStudent(Student student);
}
