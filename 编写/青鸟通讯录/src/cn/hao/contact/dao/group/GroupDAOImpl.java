package cn.hao.contact.dao.group;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.hao.contact.entity.Group;
import cn.hao.contact.util.HibernateUtil;
@Repository("ig")
public class GroupDAOImpl implements IGroupDAO{

	private Logger logger=Logger.getLogger(GroupDAOImpl.class);
	@Override
	public List<Group> listGorup() {
		List<Group> groups=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			groups=session.createQuery("from Group order by id").list();
		} catch (Exception e) {
			logger.error("获取分组发生错误");
		}finally{
			session.close();
		}
		return groups;
	}

}









