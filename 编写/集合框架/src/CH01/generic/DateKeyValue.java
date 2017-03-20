package CH01.generic;

import java.util.Date;

public class DateKeyValue {
	private String key;
	private Date date;
	public DateKeyValue(String key, Date date) {
		super();
		this.key = key;
		this.date = date;
	}
	public DateKeyValue() {
		// TODO Auto-generated constructor stub
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
