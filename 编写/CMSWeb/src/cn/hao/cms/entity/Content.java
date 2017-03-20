package cn.hao.cms.entity;

import java.util.Date;

public class Content {
	private Integer id;
	private Integer cid;
	private Integer aid;
	private String title;
	private String link;
	private String content;
	private String pic;
	private Date addtime;
	private String cname;

	public Content() {
	}
	
	public Content(Integer id, Integer cid, Integer aid, String title,
			String link, String content, String pic, Date addtime, String cname) {
		super();
		this.id = id;
		this.cid = cid;
		this.aid = aid;
		this.title = title;
		this.link = link;
		this.content = content;
		this.pic = pic;
		this.addtime = addtime;
		this.cname = cname;
	}
	public Content(Integer cid, Integer aid, String title, String link,
			String content, String pic) {
		super();
		this.cid = cid;
		this.aid = aid;
		this.title = title;
		this.link = link;
		this.content = content;
		this.pic = pic;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	
}
