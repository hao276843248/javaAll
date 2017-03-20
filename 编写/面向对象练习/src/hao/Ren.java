package hao;

public class Ren implements Comparable<Ren>{
	
	
	
	private String name;
	private int piao;
	
	public Ren() {
		
	}
	public Ren(String name,int piao) {
		this.name=name;
		this.piao=piao;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPiao() {
		return piao;
	}
	public void setPiao(int piao) {
		this.piao = piao;
	}
	@Override
	public int compareTo(Ren o) {
		return o.getPiao()-this.piao;
	}
	
	
}
