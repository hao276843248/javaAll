package lvyou.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import lvyou.dao.ManageDao;
import lvyou.model.Manage;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;





public class Util {

	//���ʱ��
	public static String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date.getTime());
	}
	
	//�������
	public static String getday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return sdf.format(date.getTime());
	}
	
	//����·�
	public static String getmonth(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date = new Date();
		return sdf.format(date.getTime());
	}

	// �ϴ��ļ�/�����ļ���
	public static void copyFile(File src, File dst) {
		try {
			int BUFFER_SIZE = 16 * 1024;
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE]; 
				for (int byteRead = 0; (byteRead = in.read(buffer)) > 0; ) 
				{ 
					out.write(buffer, 0, byteRead); 
				} 

			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String tiaozhuan(String msg, String url, String id) {
		String tiaozhuan = "{\"statusCode\":\"200\", \"message\":\"" + msg
				+ "\"," + "\"navTabId\":\"" + id + "\", \"rel\":\"" + id
				+ "\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\""
				+ url + "\"}";
		return tiaozhuan;
	}

	public static String tiaozhuan2(String msg, String url, String id) {
		String tiaozhuan = "{\"statusCode\":\"200\", \"message\":\"" + msg
				+ "\"," + "\"navTabId\":\"" + id + "\", \"rel\":\"" + id
				+ "\", \"callbackType\":\"\",\"forwardUrl\":\"" + url + "\"}";
		return tiaozhuan;
	}
	
	
	//��ʼ��ϵͳ
	public static void init(HttpServletRequest request){
		  WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
          ManageDao manageDao = (ManageDao)app.getBean("manageDao");
          Manage manage = manageDao.selectBean(" where username='admin'  ");
  		if(manage==null){
  			manage = new Manage();
  			manage.setPassword("111111");
  			manage.setUsername("admin");
  			manageDao.insertBean(manage);
  		}
	}
	
	
	//��ʼ��ϵͳ
	public static String leixing(String leixing){
		String titletitle ="";
		if("1".equals(leixing)){
			titletitle = "�ȵ�����";
		}
		if("2".equals(leixing)){
			titletitle = "�������";
		}
		if("3".equals(leixing)){
			titletitle = "������·";
		}
		if("4".equals(leixing)){
			titletitle = "�����Ƶ�";
		}
		if("5".equals(leixing)){
			titletitle = "���ķ��";
		}
		return titletitle;
	}

}
