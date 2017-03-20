package WangYe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Kuduan {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("localhost",9000);
			
			String a="haoaaaa";
			
			OutputStream os=socket.getOutputStream();
			byte[] c=a.getBytes();
			os.write(c);
			os.flush();
			socket.shutdownOutput();
			
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String b=br.readLine();
			System.out.println("返回消息为"+b);
			
			os.close();
			is.close();
			br.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
