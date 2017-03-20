package cn.hao.camera.servlet.camera;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.camera.entity.Camera;
import cn.hao.camera.util.Fanwei;
import cn.hao.camera.util.PageBean;
import cn.hao.camera.service.camera.IServiceCamera;
import cn.hao.camera.service.camera.ServiceCameraImpl;
@WebServlet("/list")
public class listCameraServlet extends HttpServlet {
	private IServiceCamera is=new ServiceCameraImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���������ַ�������
		request.setCharacterEncoding("utf-8");
		//��÷�ҳ����
		int pageIndex=1;
		int pageSize=10;
		
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		
		//��ò�ѯ����
		Long typeId=null;
		Long brandId=null;
		Fanwei pixel=null;
		Fanwei zoom=null;
		Fanwei lcd=null;
		Fanwei price=null;
		String color=request.getParameter("color");
		if(color==null){
			color="";
		}
		String title=request.getParameter("title");
		if(title==null){
			title="";
		}	

		//���Ʒ�Ʊ������
		String typeIdParam=request.getParameter("typeId");
		if(typeIdParam!=null && !typeIdParam.equals("")){
			typeId=Long.valueOf(typeIdParam);
		}
		
		//���Ʒ�Ʊ������
		String brandIdParam=request.getParameter("brandId");
		if(brandIdParam!=null && !brandIdParam.equals("")){
			brandId=Long.valueOf(brandIdParam);
		}
		
		//�����������Χ����
		String pixelParam=request.getParameter("pixel");
		if(pixelParam!=null && !pixelParam.equals("")){
			pixel=new Fanwei(pixelParam);
		}
		
		//��ñ佹������Χ����
		String zoomParam=request.getParameter("zoom");
		if(zoomParam!=null && !zoomParam.equals("")){
			zoom=new Fanwei(zoomParam);
		}
		
		//���LCD�ߴ緶Χ����
		String lcdParam=request.getParameter("lcd");
		if(lcdParam!=null && !lcdParam.equals("")){
			lcd=new Fanwei(lcdParam);
		}
		
		//��ü۸�Χ����
		String priceParam=request.getParameter("price");
		if(priceParam!=null && !priceParam.equals("")){
			price=new Fanwei(priceParam);
		}
		
		//����PageParam
		//��ѯ��ҳ�б�
		
		PageBean p=is.findCamera(pageIndex,pageSize, typeId, brandId, pixel, zoom, color, lcd, price, title);
		
		request.setAttribute("p",p);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}
