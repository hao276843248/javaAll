package cn.bdqn.camera.servlet.type;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.camera.entity.Type;
import cn.bdqn.camera.service.type.ITypeService;
import cn.bdqn.camera.service.type.TypeServiceImpl;

@WebServlet("/types")
public class ListTypeService extends HttpServlet {

	private ITypeService typeService=new TypeServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Type> types=typeService.findType();
		request.setAttribute("types",types);
	}

}
