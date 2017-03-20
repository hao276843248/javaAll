package cn.hao.sx.entity;

public class TJ {
	private String name;
	private int cid;
	private int eid;
	private int time;
	private int state;
	public TJ() {
		// TODO Auto-generated constructor stub
	}
	public TJ(String name, int cid, int eid, int time, int state) {
		super();
		this.name = name;
		this.cid = cid;
		this.eid = eid;
		this.time = time;
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
