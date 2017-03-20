package WangYe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		try {
			ServerSocket serve= new ServerSocket(9000);
			Socket soc=serve.accept();
			InputStream is=soc.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			
			String a;
			a=br.readLine();
			System.out.println("["+soc.getInetAddress().getHostAddress()+"]"+a);
			
			
			OutputStream os=soc.getOutputStream();
			String c="¿Í»§¶ËÄãºÃ£¡";
			byte[] b=c.getBytes();
			os.write(b);
			os.flush();
			
			os.close();
			br.close();
			is.close();
			isr.close();
			soc.close();
			serve.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
