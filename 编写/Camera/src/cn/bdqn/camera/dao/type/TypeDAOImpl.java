package cn.bdqn.camera.dao.type;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.camera.entity.Type;
import cn.bdqn.camera.util.HibernateUtil;

public class TypeDAOImpl implements ITypeDAO{
	private Logger logger=Logger.getLogger(TypeDAOImpl.class);
	@Override
	public List<Type> findType() {
		List<Type> types=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			types=session.createQuery("from Type order by id")
						  .list();
		} catch (Exception e) {
			logger.error("获取分类列表时发生错误",e);
		}
		finally{
			session.close();
		}
		return types;
	}

}









