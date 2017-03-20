package Service;

import java.util.List;

import util.PageBean;

import DAO.IStudentDAO;
import DAO.StudentDAOImp;

import entity.Student;
import entity.user;

public class ServiceStudent implements IServiceStudent{

	private IStudentDAO dao=new StudentDAOImp();
	@Override
	public void addSudent(Student student) {
		dao.addSudent(student);
	}

	@Override
	public List<Student> findStudent() {
		
		return dao.findStudent();
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return dao.getStudent(id);
	}

	@Override
	public void updateStudent(Student s) {
		dao.updateStudent(s);
		
	}

	@Override
	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}

	@Override
	public user login(String loginName) {
		return dao.getLoginName(loginName);
	}

	@Override
	public PageBean findStudent(int pageIndex, int pageSize, String title) {
		// TODO Auto-generated method stub
		return dao.findStudent(pageIndex, pageSize, title);
	}

}
