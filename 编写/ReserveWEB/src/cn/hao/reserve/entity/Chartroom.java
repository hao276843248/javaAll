package cn.hao.reserve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chartroom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "chartroom", catalog = "chartroom")
public class Chartroom implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ip;
	private String conrent;

	// Constructors

	/** default constructor */
	public Chartroom() {
	}

	/** full constructor */
	public Chartroom(String ip, String conrent) {
		this.ip = ip;
		this.conrent = conrent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ip", nullable = false, length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "conrent", nullable = false, length = 2000)
	public String getConrent() {
		return this.conrent;
	}

	public void setConrent(String conrent) {
		this.conrent = conrent;
	}

}