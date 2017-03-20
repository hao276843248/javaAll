package cn.bdqn.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DVDMain {
	private static DVDLuoJi dvdluoji = new DVDLuoJi();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		int x = -1;
		do {
			System.out.println("*******��ӭʹ������DVDϵͳ*******");
			System.out.println("-----------------------------");
			System.out.println("-->1.����DVD");
			System.out.println("-->2.�鿴DVD");
			System.out.println("-->3.ɾ��DVD");
			System.out.println("-->4.���DVD");
			System.out.println("-->5.�黹DVD");
			System.out.println("-->6.�˳�DVD");
			System.out.println("-----------------------------");
			System.out.print("��ѡ��:");
			x = input.nextInt();
			switch (x) {
			// ����
			case 1:
				addDVD();
				break;
			// �鿴
			case 2:
				showDVD();
				break;
			// ɾ��
			case 3:
				shanDVD();
				break;
			// ���
			case 4:
				jieDVD();
				break;
			// �黹
			case 5:
				huanDVD();
				break;

			// ����
			default:
				break;
			}
			if (x == 6) {
				break;
			} else {
				do {
					System.out.println("----------------------");
					System.out.println("����0����:");
				} while (input.nextInt() != 0);
			}

		} while (true);
	}

	public static void showDVD() {
		System.out.println("-->2.�鿴DVD");
		DVD[] dvds = dvdluoji.find();
		System.out.println("���\t״̬\t����\t\t�������\t\t�������");
		for (int i = 0; i < dvds.length; i++) {
			DVD dvd = dvds[i];
			System.out.print(i + 1 + "\t");
			if (dvd.isLended() == true) {
				System.out.print("�ѽ��\t");
			} else {
				System.out.print("�ɽ��\t");
			}
			System.out.print(dvd.getName() + "\t\t");
			if (dvd.getDate() != null) {
				System.out.print(sdf.format(dvd.getDate()) + "\t");
			} else {
				System.out.print("----------\t");
			}
			System.out.println(dvd.getTimes() + "��");
		}
	}

	public static void shanDVD() {
		System.out.println("-->3.ɾ��DVD");
		int index =0;
		System.out.println("������Ҫɾ��DVD����:");
		Scanner input = new Scanner(System.in);
		String newName = input.next();
		index=dvdluoji.delete(newName);
		if (index == -1) {
			System.out.println("û���ҵ���Ϣ��");
		} else if(index==1){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("��DVD�ѽ����");
		}
	}

	public static void addDVD(){
		System.out.println("-->1.����DVD");
		Scanner input=new Scanner(System.in);
		System.out.println("������DVD����:");
		String newName=input.next();
		//����������ݷ�װ��DVD������;
		DVD dvd=new DVD();
		dvd.setName(newName);
		dvdluoji.add(dvd);
		System.out.println("������"+newName+"���ɹ�!");
	}

	public static void jieDVD() {
		System.out.println("---->���DVD");
		System.out.println("������DVD����");
		Scanner input=new Scanner(System.in);
		String newName = input.next();
		int n=dvdluoji.jie(newName);
		if(n==-1){
			System.out.println("û���ҵ�ƥ����Ϣ!");
		} else if (n==-2) {
			System.out.println("��DVD�ѽ��!");
		} else {
			System.out.println("�����" + newName+ "���ɹ�!");
		}
	}

	public static void huanDVD() throws ParseException{
		Scanner input=new Scanner(System.in);
		System.out.println("---->�黹DVD");
		System.out.println("������DVD����");
		String newName = input.next();
		int n=dvdluoji.huan(newName);
		if (n == -1) {
			System.out.println("û���ҵ�ƥ����Ϣ!");
		} else if (n==-2) {
			System.out.println("��DVD�ѹ黹");
		} else {
			System.out.println("������黹����:");
			Date newDate = sdf.parse(input.next());
			int zujin=dvdluoji.huan(newName, newDate);
			System.out.println("�黹" + newName + "�ɹ�");
			System.out.println("Ӧ�����"+zujin+"Ԫ");
		}
	}
}


