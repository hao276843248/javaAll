
public class NewsTitles {
	private int id;
	private String newsName;
	private String creater;
	
	public NewsTitles(){}

	public NewsTitles(int id,String newsName,String creater){
		this.id=id;
		this.creater=creater;
		this.newsName=newsName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}
	
}
