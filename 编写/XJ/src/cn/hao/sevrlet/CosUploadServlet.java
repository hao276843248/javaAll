package cn.hao.sevrlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
/**
 * ʹ��cos���ʵ���ļ��ϴ�
 * 
 * @author mingxue.zhang@163.com
 * 
 */
public class CosUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -9116026245071140150L;  
	  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        File fileDir = new File(this.getServletContext()  
                .getRealPath("/FileDir"));  
        if (!fileDir.exists()) {  
            fileDir.mkdirs();  
        }  
        // �����ϴ��ļ��Ĵ�С�����������С ���׳�IOException�쳣��Ĭ�ϴ�С��1M��  
        int inmaxPostSize = 10 * 1024 * 1024;  
        MultipartRequest multirequest = null;  
        // �ϴ��ļ�����������  
        RenamePolicyCos myRenamePolicyCos = new RenamePolicyCos();  
        try {  
            // MultipartRequest()��8�ֹ��캯����  
            multirequest = new MultipartRequest(request, fileDir  
                    .getAbsolutePath(), inmaxPostSize, "GBK", myRenamePolicyCos); // GBK���ı���ģʽ�ϴ��ļ�  
            String subject = multirequest.getParameter("subject");// ��ȡ��ͨ��Ϣ  
            System.out.println(subject);  
            Enumeration<String> filedFileNames = multirequest.getFileNames();  
            String filedName = null;  
            if (null != filedFileNames) {  
                while (filedFileNames.hasMoreElements()) {  
                    filedName = filedFileNames.nextElement();// �ļ��ı��������  
                    // ��ȡ���ļ������ϴ����ļ�������Ӧ���ϴ����������е��ļ�  
                    File uploadFile = multirequest.getFile(filedName);  
                    if (null != uploadFile && uploadFile.length() > 0) {  
                        System.out.println(uploadFile.getName());  
                        System.out.println(uploadFile.getPath());  
                        System.out.println(uploadFile.length());  
                    }  
                    // ��ȡδ���������ļ�����  
                    String Originalname = multirequest  
                            .getOriginalFileName(filedName);  
                    System.out.println(Originalname);  
                }  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        this.doPost(request, response);  
    }  
}