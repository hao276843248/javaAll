package cn.hao.cms.service.content;

import java.util.List;

import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.cms.entity.Content;

public interface IContentService {
	
	public List<Content> findContent(PageParam p,String title,String cname,Integer cid);
	
	public Content getContent(int id);
	
	public void delContent(int id);
	
	public void updateContent(Content c);
	
	public void addContent(Content c);
	
	public Content getPreContent(int id);
	
	public Content getNextContent(int id);
}
