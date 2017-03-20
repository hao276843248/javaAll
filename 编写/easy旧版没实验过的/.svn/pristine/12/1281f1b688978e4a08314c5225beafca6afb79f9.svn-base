package cn.hao.easybuy.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.hao.easybuy.dao.user.IUserDAO;
import cn.hao.easybuy.entity.EasybuyComment;
import cn.hao.easybuy.entity.EasybuyProductCategory;
import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.service.comment.ICommentService;
import cn.hao.easybuy.service.productcategory.IProductCategoryService;
import cn.hao.easybuy.service.user.IUserService;
import cn.hao.easybuy.util.PageBean;

public class asdtest {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		IProductCategoryService a=(IProductCategoryService) ac.getBean("productCategoryService");

		List<EasybuyProductCategory> categories=a.find();

		System.out.println(categories.get(1).getEpcName());
	
		
		System.out.println(new Date());
	}
}
