package cn.bdqn.student.service.student;

import cn.bdqn.student.dao.student.IStudentDAO;
import cn.bdqn.student.dao.student.StudentDAOImpl;
import cn.bdqn.student.entity.Student;
import cn.bdqn.student.util.PageBean;

public class StudentServiceImpl implements IStudentService{
	
	private IStudentDAO studentDAO=new StudentDAOImpl();
	
	@Override
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	public PageBean findStudent(int pageIndex, int pageSize, String name,
			Integer courseId, Integer time, Integer educationId, Integer stat) {
		return studentDAO.findStudent(pageIndex, pageSize, name, courseId, time, educationId, stat);
	}
	
	@Override
	public Student getStudent(Integer id) {
		return studentDAO.getStudent(id);
	}
	
	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}
	
	@Override
	public void deleteStudent(Integer id) {
		studentDAO.deleteStudent(id);
	}
}








