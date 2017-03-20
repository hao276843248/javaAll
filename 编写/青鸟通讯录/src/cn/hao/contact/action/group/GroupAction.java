package cn.hao.contact.action.group;

import java.util.List;

import org.springframework.stereotype.Controller;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.Group;

public class GroupAction extends BaseAcrtion{
		
	@Override
	public String execute() throws Exception {
		List<Group> group=groupService.listGorup();
		requestMap.put("group",group);
		return NONE;
	}
	
}
