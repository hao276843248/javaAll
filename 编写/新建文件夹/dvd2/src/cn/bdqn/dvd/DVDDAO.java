package cn.bdqn.dvd;

import java.util.Arrays;
import java.util.Date;
//���ݷ��ʲ�
public class DVDDAO {
	
	private DVD[] dvds=new DVD[3];
	
	private int index;
	
	public DVDDAO(){
		dvds[0]=new DVD("������", true,new Date(), 15);
		dvds[1]=new DVD("���", false,null, 1);
		dvds[2]=new DVD("�Ÿ�", false,null, 6);
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
	
	//����DVD���ƻ�õ���DVD����
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
	
	//����DVD����ɾ��DVD
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



