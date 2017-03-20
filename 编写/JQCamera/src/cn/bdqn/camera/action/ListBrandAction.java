package cn.bdqn.camera.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import cn.bdqn.camera.entity.Brand;
import cn.bdqn.camera.service.brand.IBrandService;

import com.opensymphony.xwork2.ActionSupport;

public class ListBrandAction extends ActionSupport{

	private List<Brand> brands;
	private IBrandService brandService;;
	@Override
	
	public String execute() throws Exception {
		System.out.println("asd");
		brands=brandService.find();
		brands.add(0,new Brand(0l,"È«²¿Æ·ÅÆ",null));
		return SUCCESS;
	}
	public List<Brand> getBrands() {
		return brands;
	}
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}
	
	public void setBrandService(IBrandService brandService) {
		this.brandService = brandService;
	}
	
	
}
