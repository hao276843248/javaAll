package cn.bdqn.contact.service.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.contact.dao.group.GroupDAOImpl;
import cn.bdqn.contact.dao.group.IGroupDAO;
import cn.bdqn.contact.entity.Group;

@Service("groupService")
public class GroupServiceImpl implements IGroupService{
	
	private IGroupDAO groupDAO;
	
	@Autowired
	public void setGroupDAO(IGroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
	@Override
	public List<Group> findGroup() {
		return groupDAO.findGroup();
	}

}
