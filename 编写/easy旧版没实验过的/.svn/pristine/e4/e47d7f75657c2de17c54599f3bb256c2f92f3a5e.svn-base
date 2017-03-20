package cn.hao.easybuy.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EasybuyNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "easybuy_news", catalog = "easy")
public class EasybuyNews implements java.io.Serializable {

	// Fields

	private Integer enId;
	private String enTitle;
	private String enContent;
	private Date enCreateTime;

	// Constructors

	/** default constructor */
	public EasybuyNews() {
	}

	/** full constructor */
	public EasybuyNews(String enTitle, String enContent, Date enCreateTime) {
		this.enTitle = enTitle;
		this.enContent = enContent;
		this.enCreateTime = enCreateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EN_ID", unique = true, nullable = false)
	public Integer getEnId() {
		return this.enId;
	}

	public void setEnId(Integer enId) {
		this.enId = enId;
	}

	@Column(name = "EN_TITLE", nullable = false, length = 40)
	public String getEnTitle() {
		return this.enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}

	@Column(name = "EN_CONTENT", nullable = false, length = 1000)
	public String getEnContent() {
		return this.enContent;
	}

	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EN_CREATE_TIME", nullable = false, length = 10)
	public Date getEnCreateTime() {
		return this.enCreateTime;
	}

	public void setEnCreateTime(Date enCreateTime) {
		this.enCreateTime = enCreateTime;
	}

}