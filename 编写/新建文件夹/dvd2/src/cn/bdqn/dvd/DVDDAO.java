package cn.bdqn.dvd;

import java.util.Arrays;
import java.util.Date;
//数据访问层
public class DVDDAO {
	
	private DVD[] dvds=new DVD[3];
	
	private int index;
	
	public DVDDAO(){
		dvds[0]=new DVD("辛弃疾", true,new Date(), 15);
		dvds[1]=new DVD("李白", false,null, 1);
		dvds[2]=new DVD("杜甫", false,null, 6);
		index=2;
	}
	
	public DVD[] find(){
		return (DVD[]) Arrays.copyOf(dvds, index+1);
	}
	
	public void add(DVD dvd){
		if(++index==dvds.length){
			dvds=(DVD[]) Arrays.copyOf(dvds, dvds.length+10);
		}
		dvds[index]=dvd;
	}
	
	//根据DVD名称获得单个DVD对象
	public DVD get(String name){
		DVD dvd=null;
		for (int i = 0; i <=index;i++){
			if (name.equals(dvds[i].getName())){
				dvd=dvds[i];
				break;
			}
		}
		return dvd;
	}
	
	//根据DVD名称删除DVD
	public void delete(String name){
		int index1=-1;
		for (int i = 0; i <= index; i++) {
			if(name.equals(dvds[i].getName())){
				index1=i;
				break;
			}
		}
		for (int i = index1; i <index; i++) {
			dvds[i]=dvds[i+1];
		}
		dvds[index]=null;
		index--;
	}

}



