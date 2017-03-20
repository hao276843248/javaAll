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
	
	//对方IP地址
	private String ip;
	//对方端口号
	private int port;
	//发送者昵称
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
				//通过对话框接收用户输入的内容
				String content=JOptionPane.showInputDialog("请输入聊天内容:");
				
				//创建客户端Socket
				Socket socket=new Socket(ip,port);
				
				//获取用来向服务器端发送请求数据的输出流
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				
				//发送内容
				content=nickName+"说:"+content;
				bw.write(content);
				bw.newLine();
				bw.flush();
				
				//获得当前时间
				Date now=new Date();
				String time=sdf.format(now);
				
				//将已发送的内容显示在本地控制台上
				System.out.println("["+time+"]:"+content);	
				
				//关闭流			
				bw.close();
				//关闭连接
				socket.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}while(true);
	}

}
