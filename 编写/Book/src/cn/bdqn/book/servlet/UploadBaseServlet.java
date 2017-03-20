package cn.bdqn.book.servlet;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FilenameUtils;

public class UploadBaseServlet extends HttpServlet{

	protected ServletFileUpload sfu;
	protected String uploadPath="/manage/upload";
	protected String[] allowExtNames={"jpg","gif","png","bmp"};
	
	@Override
	public void init() throws ServletException {		
		ServletContext sc=getServletContext();
		
		//��ȡServlet��˽�г�ʼ������
		//getInitParameter(name)
		
		String tempDir="D:\\temp";
		//ͨ��ServletContext�����ȡweb.xml��<context-param>���õ�ȫ�ֳ�ʼ������
		if(sc.getInitParameter("tempDir")!=null){
			tempDir=sc.getInitParameter("tempDir");
		}
		int sizeThreshold=100;
		if(sc.getInitParameter("sizeThreshold")!=null){
			sizeThreshold=Integer.parseInt(sc.getInitParameter("sizeThreshold"));
		}
		int sizeMax=104857600;
		if(sc.getInitParameter("sizeMax")!=null){
			sizeMax=Integer.parseInt(sc.getInitParameter("sizeMax"));
		}
		int fileSizeMax=10485760;
		if(sc.getInitParameter("fileSizeMax")!=null){
			fileSizeMax=Integer.parseInt(sc.getInitParameter("fileSizeMax"));
		}		
		if(sc.getInitParameter("uploadPath")!=null){
			uploadPath=sc.getInitParameter("uploadPath");
		}
		if(sc.getInitParameter("allowExtNames")!=null){
			allowExtNames=sc.getInitParameter("allowExtNames").split(",");
		}
		
		//�����ļ��ո���̣߳��ڻ��ղ���ʹ�õ�File����ʱ�Զ�ɾ����ʱ�ļ�
		FileCleaningTracker tracker= FileCleanerCleanup.getFileCleaningTracker(sc);
		//����������Ŀ�����������ϴ����ļ�������ʱĿ¼
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//�����ļ��ո���߳�
		factory.setFileCleaningTracker(tracker);		
		//�������������ʱ�ļ���Ŀ¼
		factory.setRepository(new File(tempDir));
		//�����ֽ�����ֵ(�ֽ�)������С�ڴ�ֵ���ļ�����ֱ�ӱ������ڴ��У�����ת�浽����Ŀ¼��ʱ�ļ���
		factory.setSizeThreshold(sizeThreshold);
		//�����ϴ�������
		sfu=new ServletFileUpload(factory);
		//���������ϴ����ܵ���󳤶�(100MB)
		sfu.setSizeMax(sizeMax);
		//�����ϴ��ĵ����ļ����Ȳ�������10MB
		sfu.setFileSizeMax(fileSizeMax);		
		//����ϴ�Ŀ¼�ľ���·��
		uploadPath=sc.getRealPath(uploadPath);		
	}
	
	public void validateFileType(String fileName){
		//�ж��ļ����Ƿ���ָ������չ������
		if(FilenameUtils.isExtension(fileName,allowExtNames)==false){
			throw new InvalidFileTypeException();
		}		
	}
	
	
	
	
	
	
	
}
