package cn.hao.book.entity;

public class Users {
	private Integer id;
	private String loginName;
	private String password;
		
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Users(Integer id, String loginName, String password) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
