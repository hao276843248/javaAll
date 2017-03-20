package cn.hao.easybuy.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.hao.easybuy.entity.EasybuyProductCategory;
import cn.hao.easybuy.service.comment.ICommentService;
import cn.hao.easybuy.service.news.INewsService;
import cn.hao.easybuy.service.product.IProductService;
import cn.hao.easybuy.service.productcategory.IProductCategoryService;
import cn.hao.easybuy.service.user.IUserService;
import cn.hao.easybuy.util.PageBean;

@Controller
public class ControllerBean {

	
	protected ICommentService commentService;
	protected IProductCategoryService productCategoryService;
	protected IUserService userService;
	protected IProductService productService;
	protected INewsService newsService;
	
	@Autowired
	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}
	
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
		List<EasybuyProductCategory>  c= productCategoryService.find(null);
		List<List<EasybuyProductCategory>> e = new ArrayList();
		for (int i = 0; i < c.get(c.size() - 1).getLevel() + 1; i++) {
			List<EasybuyProductCategory> z = productCategoryService.find(i);
			e.add(z);
		}
		//突破历史的一刻。。
		List<EasybuyProductCategory> x = new ArrayList<EasybuyProductCategory>();
		for (int i = 0; i < e.size(); i++) {
			for (int j = 0; j < e.get(i).size(); j++) {
				if (i == 0) {
					x.add(e.get(i).get(j)); // 把第一层加入集合中
				}
				if (i != 0) { // 判断是否不是一层
					// 二层与前一层比较父ID等于子ID则输出在他爹所在集合位置的后面
					for (int k = 0; k < x.size(); k++) {
						if (e.get(i).get(j).getEpcParentId()
								.equals(x.get(k).getEpcId())) {
							x.add(k + 1, e.get(i).get(j));
						}
					}
				}
			}
		}
		return x;
	}
	
	@ModelAttribute("commentFind")
	public PageBean comment(){
		return commentService.findComment(1,7);
	}
	
	@ModelAttribute("news")
	public PageBean news(){
		PageBean p3=newsService.findNews(1, 7);
		return p3;
	}
}
