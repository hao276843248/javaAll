package cn.bdqn.camera.servlet.brand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.camera.entity.Brand;
import cn.bdqn.camera.service.brand.BrandServiceImpl;
import cn.bdqn.camera.service.brand.IBrandService;

@WebServlet("/brands")
public class ListBrandServlet extends HttpServlet {

	private IBrandService brandService=new BrandServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Brand> brands=brandService.findBrand();
		request.setAttribute("brands",brands);
	}

}





