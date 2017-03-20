package cn.bdqn.el.entity;

public class User {
	private int id;
	private String userName;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//Java中的属性名指的是用来间接访问私有变量的getter和setter方法的名字
	//将方法名中的get/set去掉，剩下的部分首字母小写，即为属性名

	public String getName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
