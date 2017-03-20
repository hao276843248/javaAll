package ke01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestCPT {
	public static void main(String[] args) {
		CPT pc=new CPT("���ض�",8,"SSD");
		
		ObjectOutputStream oos=null;
		try{
			OutputStream os=new FileOutputStream("E:\\CPT.TXT");
			oos=new ObjectOutputStream(os);
			oos.writeObject(pc);
			System.out.println("���л��ɹ���");
		}catch (Exception e) {
			System.out.println("�����������ʱ��������:"+e.getMessage());
		}
		finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("�ر������ʱ��������");
				}
			}
		}
	}
}
