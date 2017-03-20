package cn.bdqn.contact.dao.group;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.util.HibernateUtil;

public class GroupDAOImpl implements IGroupDAO {
	private Logger logger =Logger.getLogger(GroupDAOImpl.class);

	@Override
	public List<Group> findGroup() {
		List<Group> groups =null;
		Session session =null;
		try {
			session=HibernateUtil.getSession();
			groups=session.createCriteria(Group.class).list();
		} catch (Exception e) {
			logger.error("查询分组列表时发生错误",e);
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		return groups;
	}

}
