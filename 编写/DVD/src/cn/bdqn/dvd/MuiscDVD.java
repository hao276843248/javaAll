package cn.bdqn.dvd;

import java.util.Date;

import cn.bdqn.dvd.entity.DVD;

public class MuiscDVD extends DVD {
	private String singer;

	public MuiscDVD() {
	}
	
	public MuiscDVD(String name, boolean zt, Date date, int cs,String singer) {
		super(name, zt, date, cs);
		this.singer=singer;
	}


	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public int getFee() {
		long old=System.currentTimeMillis();  
		long newday=getDate().getTime();
		int x=(int)(Math.ceil((old-newday)/(1000D*60*60*24)));
		return x;
	}
}
