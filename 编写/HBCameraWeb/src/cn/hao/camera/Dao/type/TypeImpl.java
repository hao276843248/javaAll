package cn.hao.camera.Dao.type;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import cn.hao.camera.entity.Type;
import cn.hao.camera.util.HibernateUtil;

public class TypeImpl implements TypeMapper{

	@Override
	public List<Type> findType() {
		List<Type> ts=null;
		Session s=null;
		try {
			s=HibernateUtil.getSession();
			ts=s.createQuery("from Type order by id").list();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			s.close();
		}
		return ts;
	}

}
