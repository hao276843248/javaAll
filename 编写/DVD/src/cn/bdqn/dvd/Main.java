package cn.bdqn.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.dvd.Service.DVDService;
import cn.bdqn.dvd.entity.DVD;

public class Main {
	private static DVDService dvdservice;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		dvdservice=(DVDService) ctx.getBean("serviceDVD");
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
				// �黹
				case 5:
					huan();
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
		DVD[] dvds=dvdservice.find();
		System.out.println("---->�鿴DVD");
		System.out.println("���\t����\t״̬\t�������\t\t�������\t����/����");
		for (int i = 0; i < dvds.length; i++) {
			DVD dvd = dvds[i];
			if(!dvd.isZt()){
				System.out.print(i+1+"\t"+dvd.getName()+"\t"+"�ɽ��"+"\t");
			}else{
				System.out.print(i+1+"\t"+dvd.getName()+"\t"+"�Խ��"+"\t");
			}
			if(dvd.getDate()==null){
				System.out.print("----------");
			}else{
				System.out.print(sdf.format(dvd.getDate()));
			}
			System.out.print("\t"+dvd.getCs());
			if(dvd instanceof MovieDVD){
				MovieDVD movie=(MovieDVD)dvd;
				System.out.println("\t"+movie.getDirector()+"/--");
			}else if(dvd instanceof MuiscDVD){
				MuiscDVD muisc=(MuiscDVD)dvd;
				System.out.println("\t--/"+muisc.getSinger());
			}
		}
	}
	
	public static void add(){
		DVD dvd=null;
		Scanner input=new Scanner(System.in);
		System.out.println("---->����DVD");
		System.out.println("��ѡ��1��ӰƬDVD\t2������DVD");
		do{
			int x=input.nextInt();
			if(x==1){
				System.out.println("������ӰƬ����:");
				String newname=input.next();
				System.out.println("������ӰƬ����:");
				String d=input.next(); 
				dvd=new MovieDVD(newname,false,null,0,d);
				break;
			}else if(x==2){
				System.out.println("��������������:");
				String newname=input.next();
				System.out.println("���������ָ���:");
				String d=input.next(); 
				dvd=new MuiscDVD(newname,false,null,0,d);
				break;
			}
			System.out.println("�����������������!");
		}while(true);
		dvdservice.add(dvd);
		System.out.println("������"+dvd.getName()+"���ɹ�");
	}
	
	public static void delete(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->ɾ��DVD");
		System.out.println("������Ҫɾ��DVD������");
		String newName=input.next();
		int x=dvdservice.delete(newName);
		if(x==-1){
			System.out.println("û���ҵ�ƥ����Ϣ��");
		}else if(x==-2){
			System.out.println("��DVD�ѽ������ɾ��!");
		}else{
			System.out.println("ɾ���ɹ���");
		}
	}
	
	public static void jie(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->���DVD");
		System.out.println("������Ҫ���DVD������");
		String newName=input.next();
		int x=dvdservice.delete(newName);
		if(x==-1){
			System.out.println("û���ҵ�ƥ����Ϣ��");
		}else if(x==-2){
			System.out.println("��DVD�ѽ�����ɽ�!");
		}else{
			System.out.println("����ɹ���");
		}
	}

	public static void huan() throws ParseException{
		Scanner input=new Scanner(System.in);
		
		System.out.println("---->�黹DVD");
		System.out.println("������Ҫ�黹DVD������");
		String newName=input.next();
		int x=dvdservice.huan(newName);
		if(x==-1){
			System.out.println("û���ҵ�ƥ����Ϣ��");
		}else if(x==-2){
			System.out.println("��DVDû�н��!");
		}else{
			int zujin=dvdservice.huan(newName);
			System.out.println("�黹�ɹ������Ӧ��"+zujin+"Ԫ");
		}
	}
}
