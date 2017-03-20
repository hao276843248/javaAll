package cn.hao.contact.service.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.contact.dao.group.GroupDAOImpl;
import cn.hao.contact.dao.group.IGroupDAO;
import cn.hao.contact.entity.Group;

@Service("groupService")
public class GroupServiceImpl implements IGroupService{

	private IGroupDAO ig;
	@Autowired
	public void setIg(IGroupDAO ig) {
		this.ig = ig;
	}
	@Override
	public List<Group> listGorup() {
		return ig.listGorup();
	}
	
}
