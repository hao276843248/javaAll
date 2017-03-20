package cn.bdqn.student.dao.course;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.student.entity.Course;
import cn.bdqn.student.util.HibernateUtil;

public class CourseDAOImpl implements ICourseDAO{

	private Logger logger=Logger.getLogger(CourseDAOImpl.class);
	
	@Override
	public List<Course> findCourse() {
		List<Course> courses=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			courses=session.createQuery("from Course order by id").list();
		} catch (Exception e) {
			logger.error("获得科目列表时发生错误",e);			
		}
		finally{
			session.close();
		}
		return courses;
	}
	
	

}






