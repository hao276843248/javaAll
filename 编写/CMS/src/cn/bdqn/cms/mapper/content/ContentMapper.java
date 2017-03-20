package cn.bdqn.cms.mapper.content;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;

import cn.bdqn.cms.entity.Content;
import cn.bdqn.mybatis.plugin.PageParam;

public interface ContentMapper {

	public void addContent(Content content);
	
	public List<Content> findContent(
		@Param("pageParam")PageParam param,	
		@Param("categoryId")Integer categoryId,
		@Param("title")String title,
		@Param("categoryName")String categoryName
	);
	
	public Content getContentById(int id);
	
	public void updateContent(Content content);
	
	public void deleteContent(int id);
	
	public Content getPreContent(int id);
	
	public Content getNextContent(int id);
}








