package cn.bdqn.student.dao.education;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.student.entity.Education;
import cn.bdqn.student.util.HibernateUtil;

public class EducationDAOImpl implements IEducationDAO{
	
	private Logger logger=Logger.getLogger(EducationDAOImpl.class);
	
	@Override
	public List<Education> findEducation() {
		List<Education> educations=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			educations=session.createQuery("from Education order by id").list();
		} catch (Exception e) {
			logger.error("获得学历列表时发生错误",e);			
		}
		finally{
			session.close();
		}
		return educations;
	}

}










