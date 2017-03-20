package cn.hao.camera.servlet.type;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.camera.entity.Brand;
import cn.hao.camera.entity.Type;
import cn.hao.camera.service.brand.BrandServiceImpl;
import cn.hao.camera.service.brand.IBrandService;
import cn.hao.camera.service.type.IServiceType;
import cn.hao.camera.service.type.ServiceTypeImpl;
@WebServlet("/type")
public class listTypeServlet extends HttpServlet {

	private IServiceType it=new ServiceTypeImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Type> type=it.findType();
		request.setAttribute("type", type);
	}

}
