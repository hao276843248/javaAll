package cn.bdqn.ch05.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	//���Կͻ���
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.153",8800);
			
			//��ȡ������������˷����������ݵ������
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			
			//��ȡ�������շ��������͵���Ӧ���ݵ�������
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			//��������˷�����������
			bw.write("��ã������ǿͻ���");
			bw.newLine();
			bw.flush();
			
			//���շ������˷��ص���Ӧ����
			String response=br.readLine();
			System.out.println("�ͻ��˽��յ��������˷��͵���Ӧ����:"+response);
			
			//�ر���
			br.close();
			bw.close();
			//�ر�����
			socket.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
