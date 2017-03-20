package cn.hao.nt.entity;

public class Stat {
	private Integer id;
	private Integer visit;
	
	private Content content;

	
	public Stat() {
		// TODO Auto-generated constructor stub
	}
	public Stat(Integer id, Integer visit, Content content) {
		super();
		this.id = id;
		this.visit = visit;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
	
}
