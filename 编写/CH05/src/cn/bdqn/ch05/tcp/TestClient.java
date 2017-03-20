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

	//测试客户端
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.0.153",8800);
			
			//获取用来向服务器端发送请求数据的输出流
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			
			//获取用来接收服务器发送的响应内容的输入流
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			//向服务器端发送请求数据
			bw.write("你好！这里是客户端");
			bw.newLine();
			bw.flush();
			
			//接收服务器端返回的响应内容
			String response=br.readLine();
			System.out.println("客户端接收到服务器端发送的响应内容:"+response);
			
			//关闭流
			br.close();
			bw.close();
			//关闭连接
			socket.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
