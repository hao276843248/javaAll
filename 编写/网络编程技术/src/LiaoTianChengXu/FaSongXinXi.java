package LiaoTianChengXu;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


public class FaSongXinXi extends Thread{
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	private String ip;
	private int duiduankou;
	private String name;
	
	public FaSongXinXi(String ip, int duiduankou, String name) {
		super();
		this.ip = ip;
		this.duiduankou = duiduankou;
		this.name = name;
	}

	public void run() {
		
			do{
				try {
					
					Socket socket=new Socket(ip,duiduankou);	
					OutputStream os=socket.getOutputStream();
					OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
					BufferedWriter bw=new BufferedWriter(osw);
				
					String asd=JOptionPane.showInputDialog("ÇëÊäÈë×Ö·û´®");
					Date now=new Date();
					String time=sdf.format(now);
					asd="["+time+"]"+name+":"+asd;
					bw.write(asd);
					System.out.println(asd);
					bw.newLine();
					bw.flush();
					socket.shutdownOutput();
	
					bw.close();
					socket.close();
				}catch (Exception e) {
				
				} 
			}while(true);
			
	}
}
