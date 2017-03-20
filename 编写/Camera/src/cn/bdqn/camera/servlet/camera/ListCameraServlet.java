package cn.bdqn.camera.servlet.camera;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.service.camera.CameraServiceImpl;
import cn.bdqn.camera.service.camera.ICameraService;
import cn.bdqn.camera.util.PageBean;
import cn.bdqn.camera.util.Range;

@WebServlet("/list")
public class ListCameraServlet extends HttpServlet{
	
	private ICameraService cameraService=new CameraServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求字符集编码
		request.setCharacterEncoding("utf-8");
		//获得分页参数
		int pageIndex=1;
		int pageSize=10;
		
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		
		//获得查询条件
		Long typeId=null;
		Long brandId=null;
		Range pixel=null;
		Range zoom=null;
		Range lcd=null;
		Range price=null;
		String color=request.getParameter("color");
		if(color==null){
			color="";
		}
		String title=request.getParameter("title");
		if(title==null){
			title="";
		}
		
		
		//获得品牌编号条件
		String typeIdParam=request.getParameter("typeId");
		if(typeIdParam!=null && !typeIdParam.equals("")){
			typeId=Long.valueOf(typeIdParam);
		}
		
		//获得品牌编号条件
		String brandIdParam=request.getParameter("brandId");
		if(brandIdParam!=null && !brandIdParam.equals("")){
			brandId=Long.valueOf(brandIdParam);
		}
		
		//获得像素数范围条件
		String pixelParam=request.getParameter("pixel");
		if(pixelParam!=null && !pixelParam.equals("")){
			pixel=new Range(pixelParam);
		}
		
		//获得变焦倍数范围条件
		String zoomParam=request.getParameter("zoom");
		if(zoomParam!=null && !zoomParam.equals("")){
			zoom=new Range(zoomParam);
		}
		
		//获得LCD尺寸范围条件
		String lcdParam=request.getParameter("lcd");
		if(lcdParam!=null && !lcdParam.equals("")){
			lcd=new Range(lcdParam);
		}
		
		//获得价格范围条件
		String priceParam=request.getParameter("price");
		if(priceParam!=null && !priceParam.equals("")){
			price=new Range(priceParam);
		}
		
		
		//查询分页列表
		PageBean p=cameraService.findCamera(pageIndex,pageSize,typeId, brandId, pixel, zoom, color, lcd, price, title);
		
		request.setAttribute("p",p);		
		
		request.getRequestDispatcher("index.jsp").forward(request,response);
		
		
	}
	
}














