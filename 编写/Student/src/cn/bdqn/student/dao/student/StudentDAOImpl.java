package cn.bdqn.student.dao.student;



import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import cn.bdqn.student.entity.Student;
import cn.bdqn.student.util.HibernateUtil;
import cn.bdqn.student.util.PageBean;

public class StudentDAOImpl implements IStudentDAO {
	
	private Logger logger=Logger.getLogger(StudentDAOImpl.class);
	
	@Override
	public void addStudent(Student student) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			logger.error("保存学生时发生错误",e);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}

	@Override
	public PageBean findStudent(int pageIndex, int pageSize, String name,Integer courseId, Integer time, Integer educationId, Integer stat) {
		PageBean pageBean=new PageBean();
		
		//组装查询条件
		DetachedCriteria detCri=DetachedCriteria.forClass(Student.class);
		//创建别名，使用连接查询加载关联的课程和学历
		detCri.createAlias("education", "e");
		detCri.createAlias("course", "c");
		//判断，如果用户输入了有效的姓名关键字
		if(StringUtils.isNotEmpty(name)){
			detCri.add(Restrictions.like("name",name,MatchMode.ANYWHERE));
		}
		//判断，如果用户选择了有效的课程选项
		if(courseId!=null){
			detCri.add(Restrictions.eq("c.id",courseId));
		}
		//判断，如果用户选择了有效的上课时间选项
		if(time!=null){
			detCri.add(Restrictions.eq("time",time));
		}
		//判断，如果用户选择了有效的学历选项
		if(educationId!=null){
			detCri.add(Restrictions.eq("e.id",educationId));
		}
		//判断，如果用户选择了有效的状态选项
		if(stat!=null){
			detCri.add(Restrictions.eq("stat",stat));
		}
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//获得可执行的Criteria对象
			Criteria criteria=detCri.getExecutableCriteria(session);
			
			//查询总行数
			criteria.setProjection(Projections.rowCount());
			int rowCount=((Number)criteria.uniqueResult()).intValue();

			//计算总页数
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			
			//计算第一行行号
			int firstResult=(pageIndex-1)*pageSize;
			
			//查询分页结果
			List<Student> results=criteria.setProjection(null)
										  .setFirstResult(firstResult)
										  .setMaxResults(pageSize)
										  .addOrder(Order.desc("id"))
										  .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
										  .list();
			//封装PageBean
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(results);
			
			
		} catch (Exception e) {
			logger.error("查询学生分页列表时发生错误",e);
		}
		finally{
			session.close();
		}

		
		return pageBean;
	}
	
	@Override
	public Student getStudent(Integer id) {
		Student student=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			student=(Student)session.get(Student.class,id);			
		} catch (Exception e) {
			logger.error("根据ID获取学生对象时发生错误",e);
		}
		finally{
			session.close();
		}
		return student;
	}
	
	@Override
	public void updateStudent(Student student) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.update(student);
			tx.commit();
		} catch (Exception e) {
			logger.error("更新学生时发生错误",e);
			tx.rollback();
		}
		finally{
			session.close();
		}		
	}
	
	@Override
	public void deleteStudent(Integer id) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.createQuery("delete from Student where id=?")
				   .setInteger(0,id)
				   .executeUpdate();
			tx.commit();
		} catch (Exception e) {
			logger.error("更新学生时发生错误",e);
			tx.rollback();
		}
		finally{
			session.close();
		}		
	}
	
}










