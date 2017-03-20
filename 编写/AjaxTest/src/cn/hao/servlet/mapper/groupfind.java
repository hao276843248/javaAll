package cn.hao.servlet.mapper;

import java.util.List;

import cn.hao.servlet.entity.group;

public interface groupfind {

	public List<group> fund(int pid,int level);
	
}
