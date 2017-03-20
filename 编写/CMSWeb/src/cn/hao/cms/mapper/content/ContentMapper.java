package cn.hao.cms.mapper.content;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.cms.entity.Content;

public interface ContentMapper {
	public List<Content> findContent(
			@Param("pageParam")PageParam param,
			@Param("title")String title,
			@Param("cname")String cname,
			@Param("cid")Integer cid
			);
	
	public Content getContent(int id);
	
	public void delContent(int id);
	
	public void updateContent(Content c);
	
	public void addContent(Content c);
	
	public Content getPreContent(int id);
	
	public Content getNextContent(int id);
}
