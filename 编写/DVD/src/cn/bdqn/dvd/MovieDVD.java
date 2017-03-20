package cn.bdqn.dvd;

import java.util.Date;

import cn.bdqn.dvd.entity.DVD;

public class MovieDVD extends DVD{
	private String director;
	
	public MovieDVD() {
	}
	
	public MovieDVD(String name, boolean zt, Date date, int cs, String director) {
		super(name, zt, date, cs);
		this.director=director;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public int getFee() {
		long old=System.currentTimeMillis();  
		long newday=getDate().getTime();
		int x=(int)(Math.ceil((old-newday)/(1000D*60*60*24)));
		return x;
	}
}
