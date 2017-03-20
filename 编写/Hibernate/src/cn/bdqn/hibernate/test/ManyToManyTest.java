package cn.bdqn.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Emp;
import cn.bdqn.hibernate.entity.Project;
import cn.bdqn.hibernate.util.HibernateUtil;

public class ManyToManyTest {
	
	//添加项目
	@Test
	public void testSaveProject(){
		Project project=new Project();
		project.setName("CRM");
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(project);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		
		
	}
	
	//添加员工
	@Test
	public void testSaveEmp(){
		Emp emp=new Emp();
		emp.setName("李四");
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(emp);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
	}
	
	//员工加入项目
	@Test
	public void testEmpJoinProject(){
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			Emp emp=(Emp)session.get(Emp.class,1);
			Project project=(Project)session.get(Project.class,1);
			
			emp.getProjects().add(project);
			project.getEmps().add(emp);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}
	
	//解除员工与项目的关系
	@Test
	public void testRemoveLink(){
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			Emp emp=(Emp)session.get(Emp.class,1);
			Project project=(Project)session.get(Project.class,1);
			
			emp.getProjects().remove(project);
			project.getEmps().remove(emp);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
	}
}















