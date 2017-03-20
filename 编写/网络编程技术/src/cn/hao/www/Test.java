package cn.hao.www;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Test {
	public static void main(String[] args){
		InputStream is=null;
		BufferedReader br=null;
		try {
			Socket socket=new Socket("localhost",8800);			
			is=socket.getInputStream();
			
			
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
		
			bw.write("niha7878878778878787o");
			bw.newLine();
			bw.flush();
			socket.shutdownOutput();
			
			String reply=null;
			br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
			while(!((reply=br.readLine())==null)){
				System.out.println("我是客户端，服务器的响应为："+reply);
			}
			socket.close();
			is.close();
			os.close();
			br.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}	
