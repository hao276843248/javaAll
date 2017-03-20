package cn.bdqn.dvd.Service;

import java.util.Date;

import cn.bdqn.dvd.MovieDVD;
import cn.bdqn.dvd.MuiscDVD;
import cn.bdqn.dvd.DAO.DVDDAO;
import cn.bdqn.dvd.DAO.IDVDDAO;
import cn.bdqn.dvd.entity.DVD;

public class DVDService {
	
	private IDVDDAO dao;


	public void setDao(IDVDDAO dao) {
		this.dao = dao;
	}

	
	
	
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
		}else if(dvd.isZt()){
			return -2;
		}else{
			dao.delete(name);
			return 1;
		}
	}

	public int jie(String name){
		DVD dvd=dao.get(name);
		if(dvd==null){
			return -1;
		}else if(dvd.isZt()){
			return -2;
		}else{
			dvd.setDate(new Date());
			dvd.setZt(false);
			dvd.setCS(dvd.getCs()+1);
			return 1;
		}
	}
	
	public int huan(String name){
		DVD dvd=dao.get(name);
		if(dvd==null){
			return -1;
		}else if(!dvd.isZt()){
			return -2;
		}else{
			if(dvd instanceof MovieDVD){
				dvd=new MovieDVD();
				dvd.getFee();
			}else if(dvd instanceof MuiscDVD){
				dvd=new MuiscDVD();
				dvd.getFee();
			}
			dvd.setZt(false);
			dvd.setDate(null);
			return 1;
		}
	}
	
	
	
}