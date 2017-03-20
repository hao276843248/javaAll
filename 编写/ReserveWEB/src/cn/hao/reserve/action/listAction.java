package cn.hao.reserve.action;

import java.sql.Timestamp;

import cn.hao.reserve.util.PageBean;

public class listAction  extends BaseAction{
	private int pageIndex=1;
	private int pageSize=4;
	
	private Timestamp reserveDate=new Timestamp(System.currentTimeMillis());
	private Integer beginTime=8;
	private Integer endTime=17;
	private Integer status=1;
	
	private PageBean p;
	
	@Override
	public String execute() throws Exception {
		p=reserveService.findReserve(pageIndex, pageSize, reserveDate, beginTime, endTime, status);
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

	public Timestamp getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Integer getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public PageBean getP() {
		return p;
	}

	public void setP(PageBean p) {
		this.p = p;
	}
	
	
}
