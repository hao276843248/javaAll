package cn.bdqn.student.dao.student;

import cn.bdqn.student.entity.Student;
import cn.bdqn.student.util.PageBean;

public interface IStudentDAO {
	//添加学生
	public void addStudent(Student student);
	
	//搜索学生分页列表
	public PageBean findStudent(int pageIndex,int pageSize,String name,Integer courseId,Integer time,Integer educationId,Integer stat);

	//根据ID获取学生对象
	public Student getStudent(Integer id);
	
	//更新学生对象
	public void updateStudent(Student student);
	
	//删除学生对象
	public void deleteStudent(Integer id);
	
}












