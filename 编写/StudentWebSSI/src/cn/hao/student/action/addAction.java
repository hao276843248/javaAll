package cn.hao.student.action;

import com.opensymphony.xwork2.ModelDriven;


import cn.hao.student.entity.Student;

public class addAction extends BaseAction implements ModelDriven<Student>{

	private Student student=new Student();
	
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	@Override
	public String execute() throws Exception {
		String picString=upload();
		System.out.println(picString);
		
		student.setPic(picString);
		System.out.println(student.getBrithday());
		studentService.addStudent(student);
		
		return SUCCESS;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
