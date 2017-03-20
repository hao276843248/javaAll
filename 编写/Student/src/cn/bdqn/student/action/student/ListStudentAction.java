package cn.bdqn.student.action.student;

import cn.bdqn.student.action.BaseAction;
import cn.bdqn.student.util.PageBean;

public class ListStudentAction extends BaseAction{
	
	//分页参数
	//页号
	private int pageIndex=1;
	//每页行数
	private int pageSize=2;
	
	//查询条件
	private String s_name;
	private Integer s_courseId;
	private Integer s_time;
	private Integer s_educationId;
	private Integer s_stat;
	
	//分页结果
	private PageBean p;
	
	
	@Override
	public String execute() throws Exception {
		p=studentService.findStudent(pageIndex, pageSize, s_name, s_courseId, s_time, s_educationId, s_stat);
		return SUCCESS;
	}


	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public Integer getS_courseId() {
		return s_courseId;
	}


	public void setS_courseId(Integer s_courseId) {
		this.s_courseId = s_courseId;
	}


	public Integer getS_time() {
		return s_time;
	}


	public void setS_time(Integer s_time) {
		this.s_time = s_time;
	}


	public Integer getS_educationId() {
		return s_educationId;
	}


	public void setS_educationId(Integer s_educationId) {
		this.s_educationId = s_educationId;
	}


	public Integer getS_stat() {
		return s_stat;
	}


	public void setS_stat(Integer s_stat) {
		this.s_stat = s_stat;
	}


	public PageBean getP() {
		return p;
	}


	public void setP(PageBean p) {
		this.p = p;
	}
	
	
}





