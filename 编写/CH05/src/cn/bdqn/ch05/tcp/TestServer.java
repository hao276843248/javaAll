package cn.bdqn.ch05.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	//测试服务器端
	public static void main(String[] args) {
		System.out.println("服务器端启动");
		try {
			//创建服务器端Socket
			ServerSocket server=new ServerSocket(8800);
			
			do{
				System.out.println("服务器端准备接收客户端请求");
				//等待客户端连接
				Socket socket=server.accept();
				
				//获取用来接收客户端请求数据的输入流
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				
				//获取用来向客户端发送响应数据的输出流
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				
				//获取客户端发送的请求数据
				String request=br.readLine();
				System.out.println("服务器端接收到客户端["+socket.getInetAddress().getHostAddress()+"]发送的请求数据:"+request);
				
				//向客户端发送响应内容
				bw.write("你好！这里是服务器端");
				bw.newLine();
				bw.flush();
				
				//关闭流
				br.close();
				bw.close();
				//关闭与客户端的连接
				socket.close();
			}while(true);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
