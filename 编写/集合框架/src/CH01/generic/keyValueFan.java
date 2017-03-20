package CH01.generic;

public class keyValueFan<T> {
	private String key;
	private T value;
	
	public keyValueFan() {
		// TODO Auto-generated constructor stub
	}
	
	public keyValueFan(String key, T value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	
}
