package cn.bdqn.student.action.student;

import cn.bdqn.student.action.BaseAction;

public class DeleteStudentAction extends BaseAction {
	
	private Integer id;
	
	@Override
	public String execute() throws Exception {
		studentService.deleteStudent(id);
		return SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
