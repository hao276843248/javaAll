package wangyE;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		FileInputStream a=null;
		File c=null;
		long now=System.currentTimeMillis();
		try {
			fis=new FileInputStream("E:\\asd.zip");
			fos=new FileOutputStream("f:\\a.zip");
			byte[] aca=new byte[107374182];
			c=new File("e:\\a.ccc");
			int input ;
			while ((input=fis.read(aca))!=-1) {
				fos.write(aca,0,input);
			}
			fos.flush();
			System.out.println("������ɣ�");
		} catch (Exception e) {
			System.out.println("�����ļ�ʱ��������"+e.getMessage());
		}finally{
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				System.out.println("�ر����Ƿ�������"+e.getMessage());
			}
		}
		if(c.exists()){
			c.delete();
			System.out.println("ɾ���ɹ�");
		}
		long lod=System.currentTimeMillis();
		
		int asdasd=(int)((lod-now)/1000);
		if(asdasd==0){
			System.out.println("��ʱ"+(lod-now)+"΢��");
		}else{
			System.out.println("��ʱ"+asdasd+"��");
		}
		
	}
}







