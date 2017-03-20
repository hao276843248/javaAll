package cn.hao.student.action;

public class deleteAction extends BaseAction{

	private int id;
	@Override
	public String execute() throws Exception {
		studentService.deleteStudent(id);
		return NONE;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
