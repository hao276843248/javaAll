package cn.hao.easybuy.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EasybuyComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_comment", catalog = "easy")
public class EasybuyComment implements java.io.Serializable {

	// Fields

	private Integer ecId;
	private String ecContent;
	private Date ecCreateTime;
	private String ecReply;
	private Date ecReplyTime;
	private String ecNickName;

	// Constructors

	/** default constructor */
	public EasybuyComment() {
	}

	/** minimal constructor */
	public EasybuyComment(String ecContent, Date ecCreateTime, String ecNickName) {
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecNickName = ecNickName;
	}

	/** full constructor */
	public EasybuyComment(String ecContent, Date ecCreateTime, String ecReply,
			Date ecReplyTime, String ecNickName) {
		this.ecContent = ecContent;
		this.ecCreateTime = ecCreateTime;
		this.ecReply = ecReply;
		this.ecReplyTime = ecReplyTime;
		this.ecNickName = ecNickName;
	}
	
	
	public EasybuyComment(String ecContent, String ecReply,
			Date ecReplyTime, String ecNickName) {
		this.ecContent = ecContent;
		this.ecReply = ecReply;
		this.ecReplyTime = ecReplyTime;
		this.ecNickName = ecNickName;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EC_ID", unique = true, nullable = false)
	public Integer getEcId() {
		return this.ecId;
	}

	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	@Column(name = "EC_CONTENT", nullable = false, length = 200)
	public String getEcContent() {
		return this.ecContent;
	}

	public void setEcContent(String ecContent) {
		this.ecContent = ecContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EC_CREATE_TIME", nullable = false, length = 10)
	public Date getEcCreateTime() {
		return this.ecCreateTime;
	}

	public void setEcCreateTime(Date ecCreateTime) {
		this.ecCreateTime = ecCreateTime;
	}

	@Column(name = "EC_REPLY", length = 200)
	public String getEcReply() {
		return this.ecReply;
	}

	public void setEcReply(String ecReply) {
		this.ecReply = ecReply;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EC_REPLY_TIME", length = 10)
	public Date getEcReplyTime() {
		return this.ecReplyTime;
	}

	public void setEcReplyTime(Date ecReplyTime) {
		this.ecReplyTime = ecReplyTime;
	}

	@Column(name = "EC_NICK_NAME", nullable = false, length = 10)
	public String getEcNickName() {
		return this.ecNickName;
	}

	public void setEcNickName(String ecNickName) {
		this.ecNickName = ecNickName;
	}

}