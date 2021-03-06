package cn.bdqn.student.action.student;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ModelDriven;

import cn.bdqn.student.action.BaseAction;
import cn.bdqn.student.entity.Student;

public class UpdateStudentAction extends BaseAction implements ModelDriven<Student>{
	
	private Student student=new Student();
	
	@Override
	public Student getModel() {
		return student;
	}
	
	@Override
	public void validate() {		
		if(student.getBirthday()!=null && student.getBirthday().getTime()>System.currentTimeMillis()){
			addFieldError("birthday",getText("birthday.invalid"));
		}
	}

	@Override
	public String execute() throws Exception {		
		studentService.updateStudent(student);
		return SUCCESS;
	}
	
}









