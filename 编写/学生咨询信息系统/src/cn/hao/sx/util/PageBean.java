package cn.hao.sx.util;

import java.util.List;

public class PageBean {
	//ҳ��
	private int pageIndex;
	//ÿҳ����
	private int pageSize;
	//������
	private int rowCount;
	//��ҳ��
	private int pageCount;
	//�����б�
	private List result;
	
	public PageBean() {
		// TODO Auto-generated constructor stub
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
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	
	
}	
