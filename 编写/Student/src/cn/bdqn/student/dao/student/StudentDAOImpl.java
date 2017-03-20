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
			logger.error("����ѧ��ʱ��������",e);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}

	@Override
	public PageBean findStudent(int pageIndex, int pageSize, String name,Integer courseId, Integer time, Integer educationId, Integer stat) {
		PageBean pageBean=new PageBean();
		
		//��װ��ѯ����
		DetachedCriteria detCri=DetachedCriteria.forClass(Student.class);
		//����������ʹ�����Ӳ�ѯ���ع����Ŀγ̺�ѧ��
		detCri.createAlias("education", "e");
		detCri.createAlias("course", "c");
		//�жϣ�����û���������Ч�������ؼ���
		if(StringUtils.isNotEmpty(name)){
			detCri.add(Restrictions.like("name",name,MatchMode.ANYWHERE));
		}
		//�жϣ�����û�ѡ������Ч�Ŀγ�ѡ��
		if(courseId!=null){
			detCri.add(Restrictions.eq("c.id",courseId));
		}
		//�жϣ�����û�ѡ������Ч���Ͽ�ʱ��ѡ��
		if(time!=null){
			detCri.add(Restrictions.eq("time",time));
		}
		//�жϣ�����û�ѡ������Ч��ѧ��ѡ��
		if(educationId!=null){
			detCri.add(Restrictions.eq("e.id",educationId));
		}
		//�жϣ�����û�ѡ������Ч��״̬ѡ��
		if(stat!=null){
			detCri.add(Restrictions.eq("stat",stat));
		}
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//��ÿ�ִ�е�Criteria����
			Criteria criteria=detCri.getExecutableCriteria(session);
			
			//��ѯ������
			criteria.setProjection(Projections.rowCount());
			int rowCount=((Number)criteria.uniqueResult()).intValue();

			//������ҳ��
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			
			//�����һ���к�
			int firstResult=(pageIndex-1)*pageSize;
			
			//��ѯ��ҳ���
			List<Student> results=criteria.setProjection(null)
										  .setFirstResult(firstResult)
										  .setMaxResults(pageSize)
										  .addOrder(Order.desc("id"))
										  .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
										  .list();
			//��װPageBean
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(results);
			
			
		} catch (Exception e) {
			logger.error("��ѯѧ����ҳ�б�ʱ��������",e);
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
			logger.error("����ID��ȡѧ������ʱ��������",e);
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
			logger.error("����ѧ��ʱ��������",e);
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
			logger.error("����ѧ��ʱ��������",e);
			tx.rollback();
		}
		finally{
			session.close();
		}		
	}
	
}










