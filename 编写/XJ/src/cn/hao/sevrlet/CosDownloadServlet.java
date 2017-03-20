package cn.hao.sevrlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.ServletUtils;

public class CosDownloadServlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	        this.doPost(request, response);  
	    }  
	  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	        String filePath = "D:\\Tomcat\\apache-tomcat-6.0.26\\webapps\\CosUpload\\FileDir\\";  
	        String fileName = "2010��10�°���_2010_10_29_04_52_06_178.txt";  
	        String Originalname = "2010��10�°���.txt";  
	        String isofilename = new String(Originalname.getBytes("gb2312"),  
	                "UTF-8");  
	        response.setContentType("application/octet-stream");  
	        response.setHeader("Content-Disposition", "attachment; filename="  
	                + isofilename);  
	        ServletOutputStream out = null;  
	        try {  
	            out = response.getOutputStream();  
	            ServletUtils.returnFile(filePath + fileName, out);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (null != out) {  
	                out.close();  
	            }  
	        }  
	    }

}
