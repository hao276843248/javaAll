package cn.bdqn.camera.util;

import java.util.List;

public class PageBean {
	
	private int total;	
	private List rows;

	public PageBean() {
		// TODO Auto-generated constructor stub
	}

	public PageBean(int total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
	
}
