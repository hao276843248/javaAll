package hao;

import java.util.Scanner;

public class XiangMuDVD {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] count = new int[6];
		int[] date = new int[6];
		String[] name = new String[] { "����", "�����", "��Ϧ��", "��ũ", "��������", "ҹ��" };
		String[] state = new String[] { "�ɽ�", "�ɽ�", "�ɽ�", "�ɽ�", "�ɽ�", "�ɽ�" };
		String newName;
		int newDay = 0;
		int Shuru;
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
			Shuru = input.nextInt();
			switch (Shuru) {
			// ����
			case 1:
				System.out.println("---->����DVD");
				System.out.println("������DVD����");
				newName = input.next();
				if (name[5] != null) {
					System.out.println("DVD������������ʧ��");
					System.out.println("����������");
					break;
				} else {
					int index1 = -1;
					for (int i = 0; i < name.length; i++) {
						if (name[i] == null) {
							index1 = i;
							break;
						}
					}
					if (index1 != -1) {
						name[index1] = newName;
						count[index1] = 0;
						date[index1] = 0;
						state[index1] = "�ɽ�";
						System.out.println("���ӡ�" + newName + "���ɹ�");
					}
				}
				System.out.println("----------------------");
				System.out.println("����0����");
				int a1 = input.nextInt();
				if (a1 == 0) {
					break;
				} else {
					System.out.println("������󷵻�������");
					break;
				}
				// �鿴
			case 2:
				System.out.println("--->�鿴DVD");
				System.out.println("���\t״̬\t����\t\t�������\t�������");
				int index2 = 0;
				for (int i = 0; i < name.length; i++) {
					if (name[i] != null) {
						index2++;
					}
				}
				for (int i = 0; i < index2; i++) {
					System.out.println(i + 1 + "\t" + state[i] + "\t" + name[i]
							+ "\t\t" + date[i] + "\t" + count[i]);
				}
				System.out.println("----------------------");
				System.out.println("����0����");
				int a2 = input.nextInt();
				if (a2 == 0) {
					break;
				} else {
					System.out.println("������󷵻�������");
					break;
				}
				// ɾ��
			case 3:
				System.out.println("---->ɾ��DVD");
				System.out.println("������DVD����");
				newName = input.next();
				int index3 = -1;
				for (int i = 0; i < name.length; i++) {
					if (name[i].equals(newName)) {
						index3 = i;
						break;
					}
				}
				if (index3 == -1) {
					System.out.println("û���ҵ�ƥ����Ϣ!");
				} else {
					if (state[index3].equals("�ѽ��")) {
						System.out.println("�ѽ��������ɾ��!");
					} else {
						for (int i = index3; i < name.length - 1; i++) {
							name[i] = name[i + 1];
							count[i] = count[i + 1];
							date[i] = date[i + 1];
							state[i] = state[i + 1];
						}
						name[5] = null;
						state[5] = null;
						count[5] = 0;
						date[5] = 0;
						System.out.println("ɾ���ɹ���");
					}
				}

				System.out.println("----------------------");
				System.out.println("����0����");
				int a3 = input.nextInt();
				if (a3 == 0) {
					break;
				} else {
					System.out.println("������󷵻�������");
					break;
				}
				// ���
			case 4:
				System.out.println("---->���DVD");
				System.out.println("������DVD����");
				newName = input.next();
				int index4 = -1;

				for (int i = 0; i < name.length; i++) {
					if (newName.equals(name[i])) {
						index4 = i;
					}
				}
				if (index4 == -1) {
					System.out.println("û���ҵ�ƥ����Ϣ!");
				} else if (state[index4].equals("�ѽ��")) {
					System.out.println("��DVD�ѽ��!");
				} else {
					System.out.println("������������:");
					newDay = input.nextInt();
					if (newDay > 31 || newDay < 1) {
						System.out.println("����������ڵ���1��С�ڵ���31�����֣�����������!");
						newDay = input.nextInt();
					}
					state[index4] = "�ѽ��";
					date[index4] = newDay;
					count[index4]++;
					System.out.println("�����" + name[index4] + "���ɹ�!");
				}
				System.out.println("----------------------");
				System.out.println("����0����");
				int a4 = input.nextInt();
				if (a4 == 0) {
					break;
				} else {
					System.out.println("������󷵻�������");
					break;
				}
				// �黹
			case 5:
				System.out.println("---->�黹DVD");
				System.out.println("������DVD����");
				newName = input.next();
				int index5 = -1;
				for (int i = 0; i < name.length; i++) {
					if (newName.equals(name[i])) {
						index5 = i;
					}
				}
				if (index5 == -1) {
					System.out.println("û���ҵ�ƥ����Ϣ!");
				} else if (state[index5].equals("�ɽ�")) {
					System.out.println("��DVD�ѹ黹");
				} else {
					System.out.println("������黹����:");
					newDay = input.nextInt();
					System.out.println("�黹" + name[index5] + "�ɹ�");
					System.out.println("�������Ϊ:" + date[index5]);
					System.out.println("�黹����Ϊ:" + newDay);
					if (newDay < date[index5]) {
						System.out.println("Ӧ�����(Ԫ):"
								+ (newDay + (31 - date[index5])));
					} else {
						System.out
								.println("Ӧ�����(Ԫ):" + (newDay - date[index5]));
					}
					state[index5] = "�ɽ�";
					date[index5] = 0;

				}
				System.out.println("----------------------");
				System.out.println("����0����");
				int a5 = input.nextInt();
				if (a5 == 0) {
					break;
				} else {
					System.out.println("������󷵻�������");
					break;
				}
				// ����
			default:
				if (Shuru == 6) {
					System.out.println("��ӭ�ٴ�ʹ�ã�");
				} else {
					System.out.println("������ѡ��:");
				}
				break;
			}
		} while (Shuru != 6);
	}
}
