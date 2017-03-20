package cn.bdqn.mail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Email entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "email", catalog = "email")
public class Email implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sender;
	private String receiver;
	private String subject;
	private String text;
	private String fileName;
	private String filePath;
	private Integer send;

	// Constructors

	/** default constructor */
	public Email() {
	}

	/** minimal constructor */
	public Email(String sender, String receiver, String subject, String text,
			Integer send) {
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.text = text;
		this.send = send;
	}

	/** full constructor */
	public Email(String sender, String receiver, String subject, String text,
			String fileName, String filePath, Integer send) {
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.text = text;
		this.fileName = fileName;
		this.filePath = filePath;
		this.send = send;
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

	@Column(name = "sender", nullable = false, length = 50)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "receiver", nullable = false, length = 50)
	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "subject", nullable = false, length = 200)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "text", nullable = false, length = 4000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "fileName", length = 50)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "filePath", length = 50)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "send", nullable = false)
	public Integer getSend() {
		return this.send;
	}

	public void setSend(Integer send) {
		this.send = send;
	}

}