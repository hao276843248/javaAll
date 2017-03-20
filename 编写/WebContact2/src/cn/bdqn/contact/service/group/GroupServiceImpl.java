package cn.bdqn.contact.service.group;

import java.util.List;

import cn.bdqn.contact.dao.group.GroupDAOImpl;
import cn.bdqn.contact.dao.group.IGroupDAO;
import cn.bdqn.contact.entity.Group;

public class GroupServiceImpl implements IGroupService {
	private IGroupDAO groupDAO;
	
	public void setGroupDAO(IGroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	@Override
	public List<Group> findGroup() {
		return groupDAO.findGroup();
	}

}
