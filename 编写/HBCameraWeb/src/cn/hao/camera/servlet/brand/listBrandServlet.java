package cn.hao.camera.servlet.brand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.camera.entity.Brand;
import cn.hao.camera.service.brand.BrandServiceImpl;
import cn.hao.camera.service.brand.IBrandService;
@WebServlet("/brands")
public class listBrandServlet extends HttpServlet {

	private IBrandService ib=new BrandServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Brand> brands=ib.findBrand();
		request.setAttribute("brands", brands);
		
	}

}
