package cn.bdqn.dvd;

import java.text.ParseException;
import java.util.Date;

public class DVDLuoJi {
	
	private DVDDAO dao=new DVDDAO();
	
	public DVD[] find(){
		return dao.find();
	}
	public void add(DVD dvd){
		dao.add(dvd);
	}
	
	public int delete(String name){
		DVD dvd=dao.get(name);
		if(dvd==null){
			return -1;
		}
		else if(dvd.isLended()){
			return -2;
		}
		else{
			dao.delete(name);
			return 1;
		}
	}
	
	//借出
	public int jie(String name){
		DVD dvd=dao.get(name);
		if(dvd==null){
			return -1;
		}else if(dvd.isLended()){
			return -2;
		}else{
			dvd.setLended(true);
			dvd.setDate(new Date());
			dvd.setTimes(dvd.getTimes()+1);
			return 1;	
		}
	}
	
	//归还
	public int huan(String name){
		DVD dvd=dao.get(name);
		if(dvd==null){
			return -1;
		}else if (!dvd.isLended()){
			return -2;
		}else{
			return 1;
		}
	}
	
	//租金
	public int huan(String name,Date date) throws ParseException{
		//租金1天一块
		//获得借出日期的毫秒数
		DVD dvd=dao.get(name);
		long old = dvd.getDate().getTime();
		// 获得归还日期的毫秒数
		long time = date.getTime();
		// 判断指定的日期到现在经过的天数
		int zujin= (int) Math.ceil((time - old) / (1000D * 60 * 60 * 24));
		dvd.setDate(null);
		dvd.setLended(false);
		return zujin;
	}


}
