package cn.bdqn.tangshi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test6 {
	public static void main(String[] args) {
		try {
			Properties props=new Properties();
			//���Test6��������Ϣ
			Class c=Test6.class;
			//�����·���µ��ļ���������
			InputStream is=c.getResourceAsStream("/test.properties");
			//���������ļ��еļ�ֵ��
			props.load(is);
			System.out.println(props.getProperty("id"));
			System.out.println(props.getProperty("name"));
			System.out.println(props.getProperty("address"));
			System.out.println(props.getProperty("age"));
			
		} catch (IOException e) {
			System.out.println("��������ʱ�����쳣:"+e.getMessage());
		}
		
	}
}






