package wangyE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class StudentTset {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		FileInputStream fis=null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		try {
			
			fos=new FileOutputStream("F:\\addd.txt");
			oos=new ObjectOutputStream(fos);
			Student stu=new Student("ÕÅÈý",3,"ÄÐ");
			oos.writeObject(stu);
			
			fis=new FileInputStream("F:\\addd.txt");
			ois=new ObjectInputStream(fis);
			
			Student a=(Student)ois.readObject();
			System.out.println(a.getId()+"---"+a.getGender()+"---"+a.getName());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
				ois.close();
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
