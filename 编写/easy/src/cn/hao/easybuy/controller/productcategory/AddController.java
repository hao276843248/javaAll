package cn.hao.easybuy.controller.productcategory;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyProductCategory;
import cn.hao.easybuy.form.productategory.GroupForm;

@RequestMapping("/manage")
@Controller
public class AddController extends ControllerBean{

	@ModelAttribute("productcategoryForm1")
	public List<EasybuyProductCategory> EasybuyProductCategory(){
		List<EasybuyProductCategory> a= productCategoryService.find();
		EasybuyProductCategory b=new EasybuyProductCategory();
		b.setEpcName("跟栏目");
		b.setEpcId(0);
		a.add(0, b);
		return productCategoryService.find();
	}
	
	@ModelAttribute("groupForm")
	public GroupForm groupForm(){
		return new GroupForm();
	}
	
	
	@RequestMapping(value="productClass-add",method=RequestMethod.GET)
	public String add(){
		return "manage/productClass-add";
	}
	
	
	@RequestMapping(value="productClass-add",method=RequestMethod.POST)
	public String add(	@ModelAttribute("groupForm")GroupForm groupForm){
		
		EasybuyProductCategory e=new EasybuyProductCategory();
		List<EasybuyProductCategory> a= productCategoryService.find();
		EasybuyProductCategory b=productCategoryService.get(groupForm.getId());
		
		System.out.println(a.get(a.size()-1).getEpcId()+1);
		
		Collections.sort(a, new Comparator<EasybuyProductCategory>() {
            public int compare(EasybuyProductCategory o1, EasybuyProductCategory o2) { 
                //按照id进行升序排列  
                if(o1.getEpcId() > o2.getEpcId()){  
                    return 1;  
                }  
                if(o1.getEpcId() == o2.getEpcId()){  
                    return 0;  
                }  
                return -1;  
            }

		 }); 
		
		System.out.println(a.get(a.size()-1).getEpcId()+1);
		e.setEpcId(a.get(a.size()-1).getEpcId()+1);
		e.setEpcParentId(b.getEpcId());
		e.setEpcName(groupForm.getName());
		e.setLevel(b.getLevel()+1);
		productCategoryService.addCategory(e);
		return "redirect:productClass.html";
	}
}
