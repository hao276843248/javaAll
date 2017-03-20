package cn.bdqn.dvd.entity;
import java.util.Date;

public abstract class DVD {
	private String name;
	private Date date;
	private boolean zt;
	//true :ря╫ХЁЖ 	false:©и╫Х;
	private int cs;
	
	public  DVD(){
		
	}
	
	public DVD(String name,boolean zt,Date date ,int cs){
		this.name=name;
		this.cs=cs;
		this.zt=zt;
		this.date=date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isZt() {
		return zt;
	}
	public void setZt(boolean zt) {
		this.zt = zt;
	}
	public int getCs() {
		return cs;
	}
	public void setCS(int cs) {
		this.cs = cs;
	}
	
	public abstract int getFee();
}
