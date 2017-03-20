package cn.bdqn.student.action.student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import cn.bdqn.student.action.BaseAction;
import cn.bdqn.student.entity.Student;

public class GetStudentAction extends BaseAction {
	
	private Integer id;
	
	@Override
	public String execute() throws Exception {
		Student student=studentService.getStudent(id);
		//��õ�ǰ��ֵջ
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		//��Ҫ�༭��ѧ������ѹ��ֵջ
		valueStack.push(student);
		return SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
