package cn.hao.lyb.entity;

import java.util.Date;

public class Message {
	private int id;
	private String name;
	private String content;
	private Date date;
	private String ip;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Message(String name, String content, Date date, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.date = date;
		this.ip = ip;
	}


	public Message(int id, String name, String content, Date date, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.date = date;
		this.ip = ip;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
