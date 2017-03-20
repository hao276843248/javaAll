package cn.bdqn.dvd;

import java.util.Date;


public class DVD {
	
	private String name;
	private boolean lended;
	private Date date;
	private int times;
	
	public DVD() {
	
	}
	
	public DVD(String name,boolean lended,Date date,int times){
		this.name=name;
		this.lended =lended;
		this.date =date;
		this.times =times;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLended() {
		return lended;
	}

	public void setLended(boolean lended) {
		this.lended = lended;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
	
}
