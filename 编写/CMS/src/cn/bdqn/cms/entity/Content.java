package cn.bdqn.cms.entity;

import java.util.Date;

public class Content {
	
	private int id;
	private int cid;
	private int aid;
	private String categoryName;
	private String title;
	private String link;
	private String content;
	private String pic;
	private Date addTime;
	
	public Content() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Content(int id, int cid, int aid, String title, String link,
			String content, String pic) {
		super();
		this.id = id;
		this.cid = cid;
		this.aid = aid;
		this.title = title;
		this.link = link;
		this.content = content;
		this.pic = pic;		
	}

	public Content(int cid, int aid, String title, String link,
			String content, String pic) {
		super();		
		this.cid = cid;
		this.aid = aid;
		this.title = title;
		this.link = link;
		this.content = content;
		this.pic = pic;	
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
