package cn.bdqn.camera.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import cn.bdqn.camera.entity.Brand;
import cn.bdqn.camera.entity.Types;
import cn.bdqn.camera.service.brand.IBrandService;
import cn.bdqn.camera.service.types.ITypesService;

import com.opensymphony.xwork2.ActionSupport;

public class ListTypeAction extends ActionSupport{

	private List<Types> types;
	private ITypesService typesService;;
	@Override
	
	public String execute() throws Exception {
		System.out.println("asd");
		types=typesService.find();
		types.add(0,new Types(0l,"È«²¿Æ·ÅÆ",null));
		return SUCCESS;
	}
	public List<Types> getTypes() {
		return types;
	}
	public void setTypes(List<Types> types) {
		this.types = types;
	}
	
	public void setTypesService(ITypesService typesService) {
		this.typesService = typesService;
	}
	
	
}
