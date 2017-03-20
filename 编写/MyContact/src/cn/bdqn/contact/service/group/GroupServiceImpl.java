package cn.bdqn.contact.service.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.mapper.GroupMapper;

@Service("groupService")
public class GroupServiceImpl implements IGroupService{
	
	private GroupMapper mapper;
	@Autowired
	public void setMapper(GroupMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<Group> findGroup() {
		return mapper.findGroup();
	}

}
