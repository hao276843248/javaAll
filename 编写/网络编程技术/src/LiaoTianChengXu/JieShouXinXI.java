package LiaoTianChengXu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JieShouXinXI extends Thread {
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	private int duankou;
	public JieShouXinXI( int duankou) {
		
		this.duankou = duankou;
	}
	
	@Override
	public void run() {
		
		try {
			ServerSocket serversocket=new ServerSocket(duankou);
			
			Socket socket=serversocket.accept();
		
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			String reply=br.readLine();
			Date now=new Date();
			String asd=sdf.format(now);
			asd="["+asd+"]:"+reply;
			System.out.println(asd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
