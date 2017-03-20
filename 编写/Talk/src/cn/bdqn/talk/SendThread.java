package cn.bdqn.talk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class SendThread extends Thread{
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	
	//�Է�IP��ַ
	private String ip;
	//�Է��˿ں�
	private int port;
	//�������ǳ�
	private String nickName;
	
	public SendThread(String ip, int port, String nickName) {
		super();
		this.ip = ip;
		this.port = port;
		this.nickName = nickName;
	}

	@Override
	public void run() {
		do{
			try {				
				//ͨ���Ի�������û����������
				String content=JOptionPane.showInputDialog("��������������:");
				
				//�����ͻ���Socket
				Socket socket=new Socket(ip,port);
				
				//��ȡ������������˷����������ݵ������
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				
				//��������
				content=nickName+"˵:"+content;
				bw.write(content);
				bw.newLine();
				bw.flush();
				
				//��õ�ǰʱ��
				Date now=new Date();
				String time=sdf.format(now);
				
				//���ѷ��͵�������ʾ�ڱ��ؿ���̨��
				System.out.println("["+time+"]:"+content);	
				
				//�ر���			
				bw.close();
				//�ر�����
				socket.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}while(true);
	}

}
