package cn.hao.easybuy.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.hao.easybuy.entity.EasybuyProductCategory;
import cn.hao.easybuy.service.comment.ICommentService;
import cn.hao.easybuy.service.product.IProductService;
import cn.hao.easybuy.service.productcategory.IProductCategoryService;
import cn.hao.easybuy.service.user.IUserService;
import cn.hao.easybuy.util.PageBean;

public class ControllerBean {

	
	protected ICommentService commentService;
	protected IProductCategoryService productCategoryService;
	protected IUserService userService;
	protected IProductService productService;
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@Autowired
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	@Autowired
	public void setProductCategoryService(
			IProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	
	@ModelAttribute("productcategoryForm")
	public List<EasybuyProductCategory> EasybuyProductCategory(){
		return productCategoryService.find();
	}
	
	@ModelAttribute("commentFind")
	public PageBean comment(){
		return commentService.findComment(1,7);
	}
	
}
