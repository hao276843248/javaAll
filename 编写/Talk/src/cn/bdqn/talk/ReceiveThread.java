package cn.bdqn.talk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiveThread extends Thread{
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");

	//服务器端Socket
	private ServerSocket server;
	
	public ReceiveThread(int port){
		try {
			//创建服务器端Socket
			server=new ServerSocket(port);
		} catch (IOException e) {			
			System.out.println("打开服务器端时发生错误:"+e.getMessage());
		}
	}
	
	@Override
	public void run() {
		do{
			try {
				Socket socket=server.accept();
				
				//获取用来接收客户端请求数据的输入流
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br=new BufferedReader(isr);

				//获取客户端发送的请求数据
				String request=br.readLine();
				
				//获得当前时间
				Date now=new Date();
				String time=sdf.format(now);
							
				//将接收到的内容显示在控制台上
				System.out.println("["+time+"]:"+request);
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
		}while(true);
		
	}

}








