package cn.hao.dvd.entity;

import java.util.Date;

public class DVD {
	private int id;
	private String name;
	private String zt;
	private Date jieDate;
	private int cs;
	private String geshou;
	private String daoyan;
	public DVD() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DVD(String name, String zt, Date jieDate, int cs, String geshou,
			String daoyan) {
		super();
		this.name = name;
		this.zt = zt;
		this.jieDate = jieDate;
		this.cs = cs;
		this.geshou = geshou;
		this.daoyan = daoyan;
	}

	
	public DVD(int id, String name, String zt, Date jieDate, int cs,
			String geshou, String daoyan) {
		super();
		this.id = id;
		this.name = name;
		this.zt = zt;
		this.jieDate = jieDate;
		this.cs = cs;
		this.geshou = geshou;
		this.daoyan = daoyan;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public Date getJieDate() {
		return jieDate;
	}


	public void setJieDate(Date jieDate) {
		this.jieDate = jieDate;
	}


	public int getCs() {
		return cs;
	}
	public void setCs(int cs) {
		this.cs = cs;
	}

	public String getGeshou() {
		return geshou;
	}


	public void setGeshou(String geshou) {
		this.geshou = geshou;
	}


	public String getDaoyan() {
		return daoyan;
	}


	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}

	
	
}
