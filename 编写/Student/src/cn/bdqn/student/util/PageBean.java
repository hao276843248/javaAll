package cn.bdqn.student.util;

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
	
	//��ҳ����б�
	private List results;

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

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}
	
	
}









