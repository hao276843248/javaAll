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
	//Java�е�������ָ����������ӷ���˽�б�����getter��setter����������
	//���������е�get/setȥ����ʣ�µĲ�������ĸСд����Ϊ������

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
