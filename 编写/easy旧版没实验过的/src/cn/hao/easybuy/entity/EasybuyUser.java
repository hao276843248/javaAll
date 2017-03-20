package cn.hao.easybuy.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EasybuyUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_user", catalog = "easy")
public class EasybuyUser implements java.io.Serializable {

	// Fields

	private String euUserId;
	private String euUserName;
	private String euPassword;
	private String euSex;
	private Date euBirthday;
	private String euIdentityCode;
	private String euEmail;
	private String euMobile;
	private String euAddress;
	private Integer euStatus;
	private Set<EasybuyOrder> easybuyOrders = new HashSet<EasybuyOrder>(0);

	// Constructors

	/** default constructor */
	public EasybuyUser() {
	}

	/** minimal constructor */
	public EasybuyUser(String euUserName, String euPassword, String euSex,
			Integer euStatus) {
		this.euUserName = euUserName;
		this.euPassword = euPassword;
		this.euSex = euSex;
		this.euStatus = euStatus;
	}

	/** full constructor */
	public EasybuyUser(String euUserName, String euPassword, String euSex,
			Date euBirthday, String euIdentityCode, String euEmail,
			String euMobile, String euAddress, Integer euStatus,
			Set<EasybuyOrder> easybuyOrders) {
		this.euUserName = euUserName;
		this.euPassword = euPassword;
		this.euSex = euSex;
		this.euBirthday = euBirthday;
		this.euIdentityCode = euIdentityCode;
		this.euEmail = euEmail;
		this.euMobile = euMobile;
		this.euAddress = euAddress;
		this.euStatus = euStatus;
		this.easybuyOrders = easybuyOrders;
	}

	// Property accessors
	@Id
	@Column(name = "EU_USER_ID", unique = true, nullable = false, length = 10)
	public String getEuUserId() {
		return this.euUserId;
	}

	public void setEuUserId(String euUserId) {
		this.euUserId = euUserId;
	}

	@Column(name = "EU_USER_NAME", nullable = false, length = 20)
	public String getEuUserName() {
		return this.euUserName;
	}

	public void setEuUserName(String euUserName) {
		this.euUserName = euUserName;
	}

	@Column(name = "EU_PASSWORD", nullable = false, length = 20)
	public String getEuPassword() {
		return this.euPassword;
	}

	public void setEuPassword(String euPassword) {
		this.euPassword = euPassword;
	}

	@Column(name = "EU_SEX", nullable = false, length = 1)
	public String getEuSex() {
		return this.euSex;
	}

	public void setEuSex(String euSex) {
		this.euSex = euSex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EU_BIRTHDAY", length = 10)
	public Date getEuBirthday() {
		return this.euBirthday;
	}

	public void setEuBirthday(Date euBirthday) {
		this.euBirthday = euBirthday;
	}

	@Column(name = "EU_IDENTITY_CODE", length = 60)
	public String getEuIdentityCode() {
		return this.euIdentityCode;
	}

	public void setEuIdentityCode(String euIdentityCode) {
		this.euIdentityCode = euIdentityCode;
	}

	@Column(name = "EU_EMAIL", length = 80)
	public String getEuEmail() {
		return this.euEmail;
	}

	public void setEuEmail(String euEmail) {
		this.euEmail = euEmail;
	}

	@Column(name = "EU_MOBILE", length = 11)
	public String getEuMobile() {
		return this.euMobile;
	}

	public void setEuMobile(String euMobile) {
		this.euMobile = euMobile;
	}

	@Column(name = "EU_ADDRESS", length = 200)
	public String getEuAddress() {
		return this.euAddress;
	}

	public void setEuAddress(String euAddress) {
		this.euAddress = euAddress;
	}

	@Column(name = "EU_STATUS", nullable = false)
	public Integer getEuStatus() {
		return this.euStatus;
	}

	public void setEuStatus(Integer euStatus) {
		this.euStatus = euStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "easybuyUser")
	public Set<EasybuyOrder> getEasybuyOrders() {
		return this.easybuyOrders;
	}

	public void setEasybuyOrders(Set<EasybuyOrder> easybuyOrders) {
		this.easybuyOrders = easybuyOrders;
	}

}