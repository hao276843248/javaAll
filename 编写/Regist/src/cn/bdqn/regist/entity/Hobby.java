package cn.bdqn.regist.entity;

public class Hobby {
	private Integer id;
	private String name;
	
	public Hobby() {
		// TODO Auto-generated constructor stub
	}

	public Hobby(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
