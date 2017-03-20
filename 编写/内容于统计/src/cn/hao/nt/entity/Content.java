package cn.hao.nt.entity;



public class Content {
	private Integer id;
	private String title;
	private String content;
	
	private Stat stat;

	
	public Content() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Content(Integer id, String title, String content, Stat stat) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.stat = stat;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}
	
	
}
