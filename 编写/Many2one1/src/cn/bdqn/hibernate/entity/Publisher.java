package cn.bdqn.hibernate.entity;


public class Publisher {

	private Integer id;
	private String name;
		
	public Publisher() {
		// TODO Auto-generated constructor stub
	}
	
	public Publisher(String name) {
		super();
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









