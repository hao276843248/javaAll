package cn.hao.easybuy.controller.productcategory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hao.easybuy.controller.ControllerBean;

@RequestMapping("/manage")
@Controller
public class deleteController extends ControllerBean{

	@RequestMapping("deleteGroup_{id}")
	public String delete(@PathVariable("id")int id){
		productCategoryService.delete(id);
		return "manage/delete";
	}
}
