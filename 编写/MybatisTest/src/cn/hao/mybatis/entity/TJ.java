package cn.hao.mybatis.entity;

public class TJ {
	private String title;
	private int cid;
	private int eid;
	private int state;
	private int time;
	
	public TJ(String title, int cid, int eid, int state, int time) {
		super();
		this.title = title;
		this.cid = cid;
		this.eid = eid;
		this.state = state;
		this.time = time;
	}
	public TJ() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}
