package cn.hao.student.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.hao.student.entity.Student;

public class getAction  extends BaseAction implements ModelDriven<Student>{

	private int id;
	private Student student;
	
	

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		student=studentService.getStudent(id);
		ActionContext.getContext().getValueStack().push(student);
		System.out.println(student.getName());
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
