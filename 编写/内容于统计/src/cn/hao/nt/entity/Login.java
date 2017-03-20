package cn.hao.nt.entity;

/**
 * Login entity. @author MyEclipse Persistence Tools
 */

public class Login implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginname;
	private String password;
	private Detail detail;

	// Constructors

	/** default constructor */
	public Login() {
	}

	/** minimal constructor */
	public Login(String loginname, String password) {
		this.loginname = loginname;
		this.password = password;
	}

	/** full constructor */
	public Login(String loginname, String password, Detail detail) {
		this.loginname = loginname;
		this.password = password;
		this.detail = detail;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Detail getDetail() {
		return this.detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

}