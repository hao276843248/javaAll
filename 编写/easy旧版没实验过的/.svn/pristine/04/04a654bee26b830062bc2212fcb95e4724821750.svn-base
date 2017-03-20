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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EasybuyOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_order", catalog = "easy")
public class EasybuyOrder implements java.io.Serializable {

	// Fields

	private Integer eoId;
	private EasybuyUser easybuyUser;
	private String eoUserName;
	private String eoUserAddress;
	private Date eoCreateTime;
	private Integer eoCost;
	private Integer eoStatus;
	private Integer eoType;
	private Set<EasybuyOrderDetail> easybuyOrderDetails = new HashSet<EasybuyOrderDetail>(
			0);

	// Constructors

	/** default constructor */
	public EasybuyOrder() {
	}

	/** minimal constructor */
	public EasybuyOrder(EasybuyUser easybuyUser, Date eoCreateTime,
			Integer eoCost, Integer eoStatus, Integer eoType) {
		this.easybuyUser = easybuyUser;
		this.eoCreateTime = eoCreateTime;
		this.eoCost = eoCost;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
	}

	/** full constructor */
	public EasybuyOrder(EasybuyUser easybuyUser, String eoUserName,
			String eoUserAddress, Date eoCreateTime, Integer eoCost,
			Integer eoStatus, Integer eoType,
			Set<EasybuyOrderDetail> easybuyOrderDetails) {
		this.easybuyUser = easybuyUser;
		this.eoUserName = eoUserName;
		this.eoUserAddress = eoUserAddress;
		this.eoCreateTime = eoCreateTime;
		this.eoCost = eoCost;
		this.eoStatus = eoStatus;
		this.eoType = eoType;
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EO_ID", unique = true, nullable = false)
	public Integer getEoId() {
		return this.eoId;
	}

	public void setEoId(Integer eoId) {
		this.eoId = eoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EO_USER_ID", nullable = false)
	public EasybuyUser getEasybuyUser() {
		return this.easybuyUser;
	}

	public void setEasybuyUser(EasybuyUser easybuyUser) {
		this.easybuyUser = easybuyUser;
	}

	@Column(name = "EO_USER_NAME", length = 20)
	public String getEoUserName() {
		return this.eoUserName;
	}

	public void setEoUserName(String eoUserName) {
		this.eoUserName = eoUserName;
	}

	@Column(name = "EO_USER_ADDRESS", length = 200)
	public String getEoUserAddress() {
		return this.eoUserAddress;
	}

	public void setEoUserAddress(String eoUserAddress) {
		this.eoUserAddress = eoUserAddress;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EO_CREATE_TIME", nullable = false, length = 10)
	public Date getEoCreateTime() {
		return this.eoCreateTime;
	}

	public void setEoCreateTime(Date eoCreateTime) {
		this.eoCreateTime = eoCreateTime;
	}

	@Column(name = "EO_COST", nullable = false)
	public Integer getEoCost() {
		return this.eoCost;
	}

	public void setEoCost(Integer eoCost) {
		this.eoCost = eoCost;
	}

	@Column(name = "EO_STATUS", nullable = false)
	public Integer getEoStatus() {
		return this.eoStatus;
	}

	public void setEoStatus(Integer eoStatus) {
		this.eoStatus = eoStatus;
	}

	@Column(name = "EO_TYPE", nullable = false)
	public Integer getEoType() {
		return this.eoType;
	}

	public void setEoType(Integer eoType) {
		this.eoType = eoType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "easybuyOrder")
	public Set<EasybuyOrderDetail> getEasybuyOrderDetails() {
		return this.easybuyOrderDetails;
	}

	public void setEasybuyOrderDetails(
			Set<EasybuyOrderDetail> easybuyOrderDetails) {
		this.easybuyOrderDetails = easybuyOrderDetails;
	}

}