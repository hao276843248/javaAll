package ch03;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file=new File("D:\\text.txt");
		System.out.println("�Ƿ����"+file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.lastModified());
		System.out.println(file.length());
		
		File file2=new File("E:\\asd.exe");
		try {
			if(file2.createNewFile()){
				System.out.println("�ļ������ɹ�");
			}else{
				System.out.println("�ļ��Ѵ���");
			}
		} catch (IOException e) {
			System.out.println("�����ļ��Ƿ�������"+e.getMessage());
		}
		
		File file3=new File("E:\\exam");
		if(file3.mkdir()){
			System.out.println("Ŀ¼�����ɹ�");
		}else{
			System.out.println("Ŀ¼����ʧ��");
		}
		
	
	}
}
