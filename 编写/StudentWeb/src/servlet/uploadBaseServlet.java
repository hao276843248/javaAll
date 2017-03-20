package servlet;


import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FilenameUtils;
public class uploadBaseServlet extends HttpServlet {

	protected  ServletFileUpload sfu;
	protected String uploadPath;
	protected String[] allowExtNames={"jpg","gif","png","bmp"};
	
	@Override
	public void init() throws ServletException {		
		ServletContext sc=getServletContext();
		
		//�����ļ��ո���̣߳��ڻ��ղ���ʹ�õ�File����ʱ�Զ�ɾ����ʱ�ļ�
		FileCleaningTracker tracker= FileCleanerCleanup.getFileCleaningTracker(sc);
		//����������Ŀ�����������ϴ����ļ�������ʱĿ¼
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//�����ļ��ո���߳�
		factory.setFileCleaningTracker(tracker);		
		//�������������ʱ�ļ���Ŀ¼
		factory.setRepository(new File("D:\\temp"));
		//�����ֽ�����ֵ(�ֽ�)������С�ڴ�ֵ���ļ�����ֱ�ӱ������ڴ��У�����ת�浽����Ŀ¼��ʱ�ļ���
		factory.setSizeThreshold(100);
		//�����ϴ�������
		sfu=new ServletFileUpload(factory);
		//���������ϴ����ܵ���󳤶�(100MB)
		sfu.setSizeMax(104857600);
		//�����ϴ��ĵ����ļ����Ȳ�������10MB
		sfu.setFileSizeMax(10485760);		
		//����ϴ�Ŀ¼�ľ���·��
		uploadPath=sc.getRealPath("/manage/upload");		
	}
	
	public void validateFileType(String fileName){
		//�ж��ļ����Ƿ���ָ������չ������
		if(FilenameUtils.isExtension(fileName,allowExtNames)==false){
			throw new InvalidFileTypeException();
		}		
	}

}
