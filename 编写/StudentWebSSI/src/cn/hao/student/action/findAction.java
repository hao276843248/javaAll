package cn.hao.student.action;

import cn.hao.student.util.PageBean;

public class findAction extends BaseAction{
	
	private int pageIndex=1;
	private int pageSize=2;
	
	private String name;
	
	
	private PageBean p;
	@Override
	public String execute() throws Exception {
		p=studentService.findStudent(pageIndex, pageSize, name);
		System.out.println(name);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PageBean getP() {
		return p;
	}
	public void setP(PageBean p) {
		this.p = p;
	}
	
	
}
