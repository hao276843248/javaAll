package cn.bdqn.contact.action.group;

import java.util.List;

import org.springframework.stereotype.Controller;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Group;

public class ListGroupAction extends BaseAction{
	
	@Override
	public String execute() throws Exception {
		List<Group> groups=groupService.findGroup();
		requestMap.put("groups", groups);
		return NONE;
	}
	

}
