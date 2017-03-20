package cn.hao.sx.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.sx.DAO.IStuinfoDAO;
import cn.hao.sx.entity.Student;
import cn.hao.sx.entity.StudentFind;
import cn.hao.sx.entity.TJ;
import cn.hao.sx.util.MyBatisUtil;

public class StudentServiceImpl implements IStudentSrevice{

	public  List<StudentFind> findStudent(PageParam param,TJ tj){
		List<StudentFind> stFinds=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			IStuinfoDAO mapper=session.getMapper(IStuinfoDAO.class);
			stFinds=mapper.findStudent(param,tj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(param.getRowCount());
		System.out.println(param.getPageCount());
		
		return stFinds;
	}
	
	public List<StudentFind> findStudent(TJ tj) {
		List<StudentFind> stFinds=null;
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			IStuinfoDAO DAO=session.getMapper(IStuinfoDAO.class);
			stFinds=DAO.findStudent(tj);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
		return stFinds;
	}

	@Override
	public Student getStudent(int id) {
		Student s=null;
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			IStuinfoDAO DAO=session.getMapper(IStuinfoDAO.class);
			s=DAO.getStudent(id);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
		return s;
	}

	@Override
	public void delStudent(int id) {
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			IStuinfoDAO DAO=session.getMapper(IStuinfoDAO.class);
			DAO.delStudent(id);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
	}

	@Override
	public void addStudent(Student s) {
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			IStuinfoDAO DAO=session.getMapper(IStuinfoDAO.class);
			DAO.addStudent(s);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
	}

	@Override
	public void updateStudent(Student s) {
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			IStuinfoDAO DAO=session.getMapper(IStuinfoDAO.class);
			DAO.updateStudent(s);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
	}

}
