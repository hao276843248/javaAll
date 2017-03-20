package cn.hao.student.action;

import cn.hao.student.entity.Student;

public class updateAction extends BaseAction{

	private Student  student; 
	
	@Override
	public String execute() throws Exception {
		studentService.updateStudent(student);
		return SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
