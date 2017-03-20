package cn.hao.dvd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.hao.dvd.DAO.DVDDAOImpl;
import cn.hao.dvd.DAO.IDVDDAO;
import cn.hao.dvd.entity.DVD;

public class test {
	
	@Test
	public void addDVDtest() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date jiedate=sdf.parse("2015-11-27");
		DVD dvd=new DVD("分手大师", "可借", jiedate, 0, null, "俞白眉,邓超");
		IDVDDAO a=new DVDDAOImpl();
		a.addDVD(dvd);
	}
	
	@Test
	public void updatedvd() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date jiedate=sdf.parse("2015-10-27");
		DVD dvd=new DVD(2,"分手大师", "可借", jiedate, 0, null, "俞白眉,邓超");
		IDVDDAO a=new DVDDAOImpl();
		a.upDateDVD(dvd);
	}
	
	@Test
	public void deletedvd(){
		IDVDDAO a=new DVDDAOImpl();
		a.deleteDVD(2);
	}
	
	@Test
	public void finddvd(){
		IDVDDAO a=new DVDDAOImpl();
		List<DVD> books=a.findDVD();
		for(DVD book:books){
			System.out.println(book.getId());
			System.out.println(book.getName());
			System.out.println(book.getZt());
			System.out.println(book.getJieDate());
			System.out.println(book.getCs());
			System.out.println(book.getDaoyan());
			System.out.println(book.getGeshou());
			System.out.println("-------------------------");
		}
	}
	
}









