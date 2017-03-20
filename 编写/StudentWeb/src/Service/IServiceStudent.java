package Service;

import java.util.List;

import util.PageBean;

import entity.Student;
import entity.user;

public interface IServiceStudent {
	public void addSudent(Student student);
	
	public List<Student> findStudent();
	
	public Student getStudent(int id);
	
	public void updateStudent(Student s);
	
	public void deleteStudent(int id);
	
	public user login(String loginName);
	
	public PageBean findStudent(int pageIndex,int pageSize,String title);
}
