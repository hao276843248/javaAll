package cn.hao.cms.test;

import java.util.List;

import org.junit.Test;

import cn.hao.cms.entity.Category;
import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.category.ICategoryService;

public class Testcat {
	@Test
	public void d(){
		ICategoryService ic=new CategoryServiceImpl();
		List<Category> c=ic.findCategory("");
		System.out.println(c.size());
	}
	
}
