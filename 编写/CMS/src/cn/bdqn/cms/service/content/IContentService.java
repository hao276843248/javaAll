package cn.bdqn.cms.service.content;

import cn.bdqn.cms.entity.Content;
import cn.bdqn.cms.util.PageBean;

public interface IContentService {

	public void addContent(Content content);

	public PageBean findContent(int pageIndex,int pageSize,Integer categoryId,String title,String categoryName);
	
	public Content getContentById(int id);
	
	public void updateContent(Content content);
	
	public void deleteContent(int id);	
	
	public Content getPreContent(int id);
	
	public Content getNextContent(int id);
}
