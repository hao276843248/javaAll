package cn.bdqn.dvd.DAO;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.dvd.MovieDVD;
import cn.bdqn.dvd.MuiscDVD;
import cn.bdqn.dvd.entity.DVD;

public class DVDDAO implements IDVDDAO {
	
	private DVD[] dvds;
	private int index; 
	
	
	public void setDvds(DVD[] dvds) {
		this.dvds = dvds;
		index=dvds.length-1;
	}
	public DVDDAO(){
		
	}
	
	//查看数组
	public DVD[] find(){
		return (DVD[]) Arrays.copyOf(dvds,index+1);
	}
	//增加数组元素;
	public void add(DVD dvd){
		if(++index==dvds.length){
		dvds=(DVD[]) Arrays.copyOf(dvds,dvds.length+10);
		}
		dvds[index]=dvd;
	}
	//插找单个数组元素
	public DVD get(String name){
		DVD dvd=null;
		for (int i = 0; i < dvds.length; i++) {
			if(dvds[i].getName().equals(name)){
				dvd=dvds[i];
				break;
			}
		}
		return dvd;
	}
	//根据元素名称删除元素
	public void delete(String name){
		int x=-1;
		for (int i = 0; i <= index; i++) {
			if(name.equals(dvds[i].getName())){
				x=i;
				break;
			}
		}
		for (int i = x; i <index; i++) {
			dvds[i]=dvds[i+1];
		}
		dvds[index]=null;
		index--;
	}
	
	
	
}


