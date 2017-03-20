package cn.hao.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.hao.dvd.Service.DVDServiceImpl;
import cn.hao.dvd.entity.DVD;

public class Main {
	private static DVDServiceImpl dvdservice= new DVDServiceImpl();
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws ParseException {
		Scanner input=new Scanner(System.in);
		do {
			System.out.println("��  ӭ  ʹ  ��  ��  ��   DVD ��  ��  ��");
			System.out.println("----------------------");
			System.out.println("1. �� �� DVD");
			System.out.println("2. �� �� DVD");
			System.out.println("3. ɾ �� DVD");
			System.out.println("4. �� �� DVD");
			System.out.println("5. �� �� DVD");
			System.out.println("6. �� �� DVD");
			System.out.println("----------------------");
			System.out.println("��ѡ��");
			int x=input.nextInt();
			switch (x){ 
				// ����
				case 1:
					add();
					break;
				// �鿴
				case 2:
					showDVD();
					break;
				// ɾ��
				case 3:
					delete();
					break;
				// ���
				case 4:
					jie();
					break; 
				default:
					break;
			}
			if(x==6){
				break;
			}else{
				do{
					System.out.println("----------------------");
					System.out.println("������0����");
				}while(input.nextInt()!=0);
			}
		} while (true);
	}
 	
	public static void showDVD() throws ParseException{
		List<DVD> dvds=dvdservice.findDVD();
		System.out.println("---->�鿴DVD");
		System.out.println("ID\t����\t״̬\t�������\t����\t����\t�������\t");
		for (DVD dvd:dvds) {
			System.out.println(dvd.getId()+"\t"+dvd.getName()+"\t"+dvd.getZt()+"\t"+dvd.getCs()+"\t"+dvd.getDaoyan()+"\t"+dvd.getGeshou()+"\t"+dvd.getJieDate());
		}
	}
	
	public static void add() throws ParseException{
		DVD dvd=null;
		Scanner input=new Scanner(System.in);
		System.out.println("---->����DVD");
		System.out.println("��ѡ��1��ӰƬDVD\t2������DVD");
		int a=input.nextInt();
		if(a==1){
			dvd=new DVD();
			System.out.println("����������");
			String name=input.next();
			dvd.setName(name);
			System.out.println("������״̬");
			String zt=input.next();
			dvd.setZt(zt);
			System.out.println("��������ʱ��(yyyy-mm-dd)");
			String ac=input.next();
			Date asd=sdf.parse(ac);
			dvd.setJieDate(asd);
			System.out.println("������������");
			int cs=input.nextInt();
			dvd.setCs(cs);
			System.out.println("������ӰƬ����");
			String daoyan=input.next();
			dvd.setDaoyan(daoyan);
			dvdservice.addDVD(dvd);
		}else if(a==2){
			dvd=new DVD();
			System.out.println("����������");
			String name=input.next();
			dvd.setName(name);
			System.out.println("������״̬");
			String zt=input.next();
			dvd.setZt(zt);
			System.out.println("��������ʱ��(yyyy-mm-dd)");
			String ac=input.next();
			Date asd=sdf.parse(ac);
			dvd.setJieDate(asd);
			System.out.println("������������");
			int cs=input.nextInt();
			dvd.setCs(cs);
			System.out.println("�������������");
			String geshou=input.next();
			dvd.setGeshou(geshou);
			dvdservice.addDVD(dvd);
		}
		dvdservice.addDVD(dvd);
		System.out.println("������"+dvd.getName()+"���ɹ�");
	}
	
	public static void delete(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->ɾ��DVD");
		System.out.println("������Ҫɾ��DVD��ID");
		int id=input.nextInt();
		DVD dvd=dvdservice.getDVD(id);
		if(dvd==null){
			System.out.println("û���ҵ�ƥ����Ϣ��");
		}else if(dvd.getZt().equals("���")){
			System.out.println("��DVD�ѽ������ɾ��!");
		}else{
			System.out.println("ɾ���ɹ���");
			dvdservice.deleteDVD(id);
		}
	}
	
	public static void jie(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->���DVD");
		System.out.println("������Ҫ���DVD������");
		int id=input.nextInt();
		DVD dvd=dvdservice.getDVD(id);
		if(dvd==null){
			System.out.println("û���ҵ�ƥ����Ϣ��");
		}else if(dvd.getZt().equals("���")){
			System.out.println("��DVD�ѽ�����ɽ�!");
		}else{
			System.out.println("����ɹ���");
			dvd.setZt("���");
			dvd.setJieDate(new Date());
			dvdservice.updateDVD(dvd);
		}
	}
}
