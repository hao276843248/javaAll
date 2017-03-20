package cn.hao.www;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serbversocket=null;
		InputStream is=null;
		OutputStream os=null;
		System.out.println("服务器启动");
		try {
			serbversocket = new ServerSocket(8800);
			do{
				System.out.println("服务器端准备接收客户端请求");
				
				Socket socket=serbversocket.accept();
				is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				
				String request;
				while((request=br.readLine())!=null){
					System.out.println("我是服务器端！客户登录信息为"+request);
				}
				System.out.println("服务器端接受客户端发送的请求响应");
				
				bw.write("你好！这里是服务器端！");
				bw.newLine();
				bw.flush();
				
				
				br.close();
				bw.close();
				socket.close();
			}while(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
}
