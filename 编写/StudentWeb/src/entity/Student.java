package entity;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private String gender;
	private String dianhua;
	private String nianji;
	private Date shengri;
	private String dizhi;
	private String mima;
	private String pic;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String name, String gender, String dianhua, String nianji,
			Date shengri, String dizhi, String mima, String pic) {
		super();
		this.name = name;
		this.gender = gender;
		this.dianhua = dianhua;
		this.nianji = nianji;
		this.shengri = shengri;
		this.dizhi = dizhi;
		this.mima = mima;
		this.pic = pic;
	}


	public Student(int id, String name, String gender, String dianhua,
			String nianji, Date shengri, String dizhi, String mima,String pic) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dianhua = dianhua;
		this.nianji = nianji;
		this.shengri = shengri;
		this.dizhi = dizhi;
		this.mima = mima;
		this.pic=pic;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getNianji() {
		return nianji;
	}
	public void setNianji(String nianji) {
		this.nianji = nianji;
	}
	public Date getShengri() {
		return shengri;
	}
	public void setShengri(Date shengri) {
		this.shengri = shengri;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	
}
